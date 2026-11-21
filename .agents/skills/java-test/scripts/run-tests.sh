#!/usr/bin/env bash
set -euo pipefail

if [[ $# -ne 1 ]]; then
    echo "Usage: $0 <project-root>" >&2
    exit 2
fi

PROJECT_ROOT="$(cd "$1" && pwd)"

cd "$PROJECT_ROOT"

if [[ ! -f pom.xml ]]; then
    echo "ERROR: pom.xml not found" >&2
    exit 1
fi

echo "Running Maven tests in: $PROJECT_ROOT"

if [[ -x ./mvnw ]]; then
    ./mvnw test
else
    mvn test
fi

echo "Maven tests completed successfully."
