Feature: sample karate test script
  for help, see: https://github.com/intuit/karate/wiki/IDE-Support

  Background:
    * url 'https://6081ec6073292b0017cde56f.mockapi.io/api/v1/'

  Scenario: get all users and then get the first user by id
    Given path 'users'
    When method get
    Then status 200

    * def first = response[0]
    * print 'The value of first is : ', first

    Given path 'users', first.id
    When method get
    Then status 200


  Scenario: create a user and then get it by id
    * def user =
    """
    {
        "name": "Viridiana",
        "country": "MX"
    }
    """

    Given path 'users'
    And request user
    When method post
    Then status 201
    * def id = response.id
    * print 'created id is : ', id


