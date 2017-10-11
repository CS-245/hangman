<p align="center"><img src="https://laravel.com/assets/img/components/logo-laravel.svg"></p>

<p align="center">
<a href="https://travis-ci.org/laravel/framework"><img src="https://travis-ci.org/laravel/framework.svg" alt="Build Status"></a>
<a href="https://packagist.org/packages/laravel/framework"><img src="https://poser.pugx.org/laravel/framework/d/total.svg" alt="Total Downloads"></a>
<a href="https://packagist.org/packages/laravel/framework"><img src="https://poser.pugx.org/laravel/framework/v/stable.svg" alt="Latest Stable Version"></a>
<a href="https://packagist.org/packages/laravel/framework"><img src="https://poser.pugx.org/laravel/framework/license.svg" alt="License"></a>
</p>

## KW Middeware

* Laravel v5.5

## Requirements

* Java JDK 1.8
* PHP [exec()](http://php.net/manual/function.exec.php) function

## Optional

* [Mysql JDBC Driver](http://dev.mysql.com/downloads/connector/j/) (If you want to use a database)
* [PostgreSQL JDBC Driver](https://jdbc.postgresql.org/download.html) (If you want to use a database)
* [Microsoft JDBC Drivers](https://www.microsoft.com/en-US/download/details.aspx?id=11774) (If you want to use a database)
* [Jaspersoft Studio](http://community.jaspersoft.com/project/jaspersoft-studio) (to draw and compile your reports)

### Java(JDK)

Check if you already have Java installed:

```
$ javac -version
javac version 1.8.0_101
```

If you get:

    command not found: javac

Then install it with: (Ubuntu/Debian)

    $ sudo apt-get install default-jdk

To install on: (centOS/Fedora)

    # yum install java-1.8.0-openjdk.x86_64

To install on windows visit the link-> [JDK](http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html) and look for the most appropriate version for your system.

Now run the `javac -version` again and check if the output is ok.

## Passport
install

    php artisan passport:install

Deploying Passport 필요한 경우에만

    php artisan passport:keys
    
Creating A Personal Access Client
    
    php artisan passport:client --personal

Creating A Password Access Client

    php artisan passport:client --password

## Queue
start worker
    
    php artisan queue:work --queue=high,low

restart worker

    php artisan queue:restart

show failed job list

    php artisan queue:failed

try failed job

    php artisan queue:retry 2(failed job ID)

## License

The Laravel framework is open-sourced software licensed under the [MIT license](http://opensource.org/licenses/MIT).
