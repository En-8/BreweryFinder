#!/bin/bash

rm ~/apache-tomcat-9.0.29/webapps/BreweryFinder.war &&
rm -r ~/apache-tomcat-9.0.29/webapps/BreweryFinder;
cp target/BreweryFinder.war ~/apache-tomcat-9.0.29/webapps
