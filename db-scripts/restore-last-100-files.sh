#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
if [[ -f "$SCRIPT_DIR/.env" ]]; then
  # shellcheck source=.env
  source "$SCRIPT_DIR/.env"
else
  echo "Error: .env file not found in $SCRIPT_DIR" >&2
  exit 1
fi

: "${DATABASE_NAME:?DATABASE_NAME is not set in .env}"

mysql --login-path=master-db "$DATABASE_NAME" < dump_last_100.sql

