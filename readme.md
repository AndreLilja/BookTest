# BookLoan Projekt

## Beskrivning 

Detta projekt är en Webservice i form av ett API som hanterar användarregistrering, autentisering och boklån. Syftet är 
att erbjuda ett enkelt och effektivt system för att hantera olika användarroller (Admin och User) och lånhantering för böcker.
Projektet är en Maven Spring Boot-applikation med integration av Spring Security för autentisering och kryptering. Applikationen
är byggd för att tillgodose CRUD-operationer och en tydlig rollbaserad åtkomst.


## Teknisk Specifikation 

- **Tekniker**: Java, Maven, Spring Boot, Spring Data JPA, Spring Security, MySQL, Lombok
-  **CI/CD Tools**: GitHub Actions, AWS
-  **Testing**: Enhetstester med GitHub Actions, grundläggande tester för validering och säkerhet
-  **Databas**: MySQL för användar- och boklagring

## Installation 

- **Besök projektet på GitHub**: [BookLoan Repository](https://github.com/AndreLilja/BookTest).
- **Klona projektet** till din lokala maskin:

-  git clone https://github.com/AndreLilja/BookTest.git
-  cd BookTest

## CI/CD

I detta projekt planeras en CI/CD-pipeline som automatisera bygg och test deploy processen via GitHub Actions och AWS. 
Genom att använda en pipeline säkerställs att alla kodändringar går igenom enhetstester och kvalitetskontroll innan distribution.

## GitHub actions

Denna pipeline kommer att:
- Köra enhetstester för att validera varje push och PR.
- Automatisera byggprocessen och paketera applikationen.

## AWS Deployment 

- AWS Pipeline:
- AWS Codebuild:
- AWS BeanStalk:
- AWS RDS:

# Endpoints

Projektet använder Swagger för att dokumentera och visualisera API-endpoints. Nedan visas en lista över centrala endpoints för att hantera användare och böcker.

## Användarendpoints

| Metod | Endpoint                       | Beskrivning                    | Åtkomstroll |
|-------|--------------------------------|--------------------------------|-------------|
| POST  | `/api/user/register`           | Registrera ny användare        | Public      |
| GET   | `/api/user/{id}`               | Hämta användare med ID         | User/Admin  |
| GET   | `/api/user/username/{username}`| Sök användare med användarnamn | User/Admin  |

## Bokendpoints

| Metod | Endpoint                | Beskrivning          | Åtkomstroll |
|-------|--------------------------|----------------------|-------------|
| GET   | `/api/books`             | Hämta alla böcker   | User/Admin  |
| POST  | `/api/books/add`         | Lägg till ny bok     | Admin       |
| DELETE| `/api/books/delete/{id}` | Ta bort en bok      | Admin       |

## Adminendpoints

| Metod | Endpoint                | Beskrivning            | Åtkomstroll |
|-------|--------------------------|------------------------|-------------|
| GET   | `/api/admin/users`       | Lista alla användare   | Admin       |
| DELETE| `/api/admin/user/{id}`   | Ta bort en användare   | Admin       |


## Testning

Varje push event kör via GitHub Actions för att säkerställa kodkvalitet och funktionalitet. Enhetstester för tjänstemetoder 
och databasinteraktioner är inkluderade för att säkerställa grundläggande funktioner 