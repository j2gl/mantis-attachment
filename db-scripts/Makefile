MYSQL_LOGIN_PATH = plastimaxbt
MYSQL_HOST = localhost
MYSQL_PORT = 3306

default: connect-mysql


# --------------------------
# Connect to MySQL
# --------------------------
connect-mysql:
	mysql --login-path=${MYSQL_LOGIN_PATH}

db-create-config:
	mysql_config_editor set --login-path=$(MYSQL_LOGIN_PATH) --host=${MYSQL_HOST} --port=${MYSQL_PORT} --user=root --password

db-print-config:
	mysql_config_editor print --all