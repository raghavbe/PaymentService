# 💳 Payment Service

The **Payment Service** is the financial transaction handler for the e-commerce ecosystem. It abstracts complex payment logic behind a simple API, currently featuring a robust integration with **Stripe** to securely process payments and generate checkout links.


## 🚀 Key Features

### Core Payment Processing
* **Stripe Integration:** Seamless integration with Stripe for secure, PCI-compliant payment processing.
* **Payment Links:** Generates hosted payment page URLs (Checkout Sessions) for users to complete transactions.
* **Gateway Pattern:** Implements a flexible **Strategy Pattern** (via `PaymentGateway` interface), making it easy to swap or add providers (like Razorpay or PayPal) in the future without changing core logic.

### Architecture & Design
* **Loose Coupling:** The controller delegates logic to the `PaymentService`, which utilizes specific `Gateway` implementations (e.g., `StripeGateway`).
* **Scalable Design:** Built to handle high volumes of transaction requests asynchronously if needed.

## 🛠️ Tech Stack

* **Language:** Java 17+
* **Framework:** Spring Boot 3.x
* **Payment Processor:** Stripe API
* **Database:** MySQL (for transaction logs)
* **Build Tool:** Maven

## 🔌 API Endpoints

The service exposes REST endpoints to initiate and manage payments.

| Method | Endpoint | Description | Response |
| :--- | :--- | :--- | :--- |
| `POST` | `/payments` | **Initiate Payment:** Creates a Stripe checkout session and returns the payment URL. | `String` (Payment URL) |
| `POST` | `/payments/webhook` | *(Planned)* Webhook endpoint to receive payment success/failure events from Stripe. | `200 OK` |

## ⚙️ Configuration

To run this application, you must configure your Stripe API keys. Update `application.properties` or `application.yml`:

```properties
# Server Configuration
server.port=8082

# Stripe Configuration
stripe.api.key=sk_test_YOUR_STRIPE_SECRET_KEY
stripe.webhook.secret=whsec_YOUR_WEBHOOK_SECRET

# Database Configuration (If storing logs)
spring.datasource.url=jdbc:mysql://localhost:3306/payment_db
spring.datasource.username=root
spring.datasource.password=your_password