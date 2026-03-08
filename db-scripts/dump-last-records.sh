#!/usr/bin/env bash
set -euo pipefail

# Load environment variables from .env file in the same directory
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
if [[ -f "$SCRIPT_DIR/.env" ]]; then
  # shellcheck source=.env
  source "$SCRIPT_DIR/.env"
else
  echo "Error: .env file not found in $SCRIPT_DIR" >&2
  exit 1
fi

: "${DATABASE_NAME:?DATABASE_NAME is not set in .env}"

TODAY=$(date +%Y-%m-%d)
DIRECTORY=../temp
DUMP_FULL="$DIRECTORY/${TODAY}_mantis-db_no-bug-file-table.sql"
NUMBER_OF_FILES=100
DUMP_LAST_FILES="$DIRECTORY/${TODAY}_mantis-db_partial_bug-file-table.sql"

# Dump the full database, excluding the large mantis_bug_file_table
mysqldump --login-path=jjmysqldb2 \
  --single-transaction \
  --hex-blob \
  --ignore-table="$DATABASE_NAME.mantis_bug_file_table" \
  "$DATABASE_NAME" \
  > "$DUMP_FULL"

# Dump only the last 100 rows of mantis_bug_file_table
mysqldump --login-path=jjmysqldb2 \
  --single-transaction \
  --hex-blob \
  --complete-insert \
  "$DATABASE_NAME" "mantis_bug_file_table" \
  --where "1 ORDER BY id DESC LIMIT $NUMBER_OF_FILES" \
  > "$DUMP_LAST_FILES"
