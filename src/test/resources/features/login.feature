#language: en
#project: Credito Libre Inversion
#client: Pichincha
#made by: Sofka Technologies
#phone: (4) 366 83 25
#website: https://registrobeta.pibank.ws/


@LOGIN
#noinspection CucumberTableInspection
Feature: As an user i need to login into expres
  Its required to login in expres for to do any action in the app
  Scenario: The user comment any thing to interact with the social media
    Given the user open expres page
    When the user enter the username and password
    Then the user can see the admin module