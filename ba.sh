#!/bin/bash

echo "=== FIXING SPRING BOOT BACKEND ==="

if [ ! -f pom.xml ]; then
  echo "❌ ERROR: pom.xml not found. Run this script inside /backend folder!"
  exit 1
fi

BASE_DIR="src/main/resources"

echo "→ Ensuring resources directory exists..."
mkdir -p $BASE_DIR

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

echo "→ Running Maven clean + package..."
mvn clean package -DskipTests

echo "=== DONE ==="
echo "Your JAR file should now be inside: target/"

