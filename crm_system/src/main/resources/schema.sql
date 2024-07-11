CREATE DATABASE crm_system;

USE crm_system;

CREATE TABLE contacts (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(20),
    company VARCHAR(255)
);

CREATE TABLE sales (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    contact_id BIGINT,
    amount DECIMAL(10, 2),
    status VARCHAR(50),
    FOREIGN KEY (contact_id) REFERENCES contacts(id)
);

CREATE TABLE tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    assigned_to VARCHAR(100) NOT NULL,
    due_date DATE NOT NULL,
    status ENUM('Pending', 'Completed', 'Overdue') NOT NULL
);

CREATE TABLE support_tickets (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    contact_id BIGINT,
    issue_description TEXT,
    status VARCHAR(50),
    FOREIGN KEY (contact_id) REFERENCES contacts(id)
);
