[![Build Status](https://travis-ci.org/Milfist/Drone-Modurarized.svg?branch=master)](https://travis-ci.org/Milfist/Drone-Modurarized) [![codecov](https://codecov.io/gh/Milfist/Drone-Modurarized/branch/master/graph/badge.svg)](https://codecov.io/gh/Milfist/Drone-Modurarized) [![Maintainability](https://api.codeclimate.com/v1/badges/03cf7edeeb4ee44fa5a2/maintainability)](https://codeclimate.com/github/Milfist/Drone-Modurarized/maintainability) [![Test Coverage](https://api.codeclimate.com/v1/badges/03cf7edeeb4ee44fa5a2/test_coverage)](https://codeclimate.com/github/Milfist/Drone-Modurarized/test_coverage)

# Drone Modularized

# [Milfist][0] Drone 2.0

## Description
This is the modularized version of the Drone project. It is modularized with Maven and Java9, separating the tests from the code and creating differentiated modules. Java9 code execution modules have also been created. This has been given to be able to use the investment obtaining the instance from the Java module and not having to assign it directly in the class. This decouples our code.
I also wanted to keep all the advances of the Drone project and that there are two test modules.

### What will I find?

It is the modularization of the **[Drone][1]** application both in **Java 9** modules and in **Maven** modules. It has a continuous integration with **Travis CI**, unit test coverage report and is integrated with **CodeClimate** and **Codecov**.

### What I can do?

* <code>*mvn clean install*</code>: Build traditional maven modules.
* <code>*mvn clean install -P j9*</code>: Build executable java9 modules.
* <code>*mvn exec:exec*</code>: The modules drone-app and drone-exec-test, can be executed if we enter their roots and execute this sentence.
* <code>*mvn test*</code>: Execute the unit tests and generate the coverage report.
* <code>*mvn verify -P integration-test*</code>: Execute the integration test.
<!--* <code>*mvn site*</code>: Generate Javadoc documentation.-->

### You want to know more?

You can check the documentation by clicking [**HERE**][1]


# By:

[![alt text](https://github.com/Milfist/Docs/blob/master/milfist.JPG)][1]

[0]: https://github.com/Milfist/
[1]: https://milfist.github.io/Drone
