#!/bin/bash

echo "=== FIXING SPRING BOOT BACKEND DATABASE + BUILD ==="

BASE_DIR="src/main/resources"

echo "→ Removing old SQL files..."
rm -f $BASE_DIR/data.sql
rm -f $BASE_DIR/schema.sql

echo "→ Creating schema.sql..."
cat << 'EOF' > $BASE_DIR/schema.sql
CREATE TABLE IF NOT EXISTS admin (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);
EOF

echo "→ Creating data.sql..."
cat << 'EOF' > $BASE_DIR/data.sql
INSERT INTO admin (username, password)
VALUES ('admin', '{noop}admin123');
EOF

echo "→ Updating application.properties..."
cat << 'EOF' > $BASE_DIR/application.properties
spring.datasource.url=jdbc:h2:mem:vgdloorderdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.h2.console.enabled=true

spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true

spring.sql.init.mode=always
spring.jpa.defer-datasource-initialization=true

spring.security.user.name=
spring.security.user.password=
EOF

echo "→ Cleaning and packaging Maven project..."
mvn clean package -DskipTests

echo "=== DONE! ==="
echo "Check your JAR inside: target/"

