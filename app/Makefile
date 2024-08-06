.DEFAULT_GOAL := build-run

run-dist:
	./build/install/app/bin/app

setup:
	./gradlew wrapper --gradle-version 8.3

clean:
	./gradlew clean

install:
	./gradlew clean install

run:
	./gradlew run

test:
	./gradlew test

lint:
	./gradlew checkstyleMain checkstyleTest

report:
	./gradlew jacocoTestReport

check-deps:
	./gradlew dependencyUpdates -Drevision=release

build-run: build run

.PHONY: build
build:
	./gradlew clean build