-- Додати нове поле з ціною до таблиці ingredients
ALTER TABLE ingredients
    ADD COLUMN price DECIMAL(10, 2) NOT NULL DEFAULT 0;
