from pathlib import Path
import xml.etree.ElementTree as ET

from mcp.server import MCPServer

mcp = MCPServer("springboot-lab")

PROJECT_ROOT = Path(__file__).resolve().parents[2]


@mcp.tool()
def inspect_maven_project() -> dict:
    """Read Maven project metadata from pom.xml."""
    pom = PROJECT_ROOT / "pom.xml"

    if not pom.is_file():
        return {"error": "pom.xml not found"}

    root = ET.parse(pom).getroot()
    ns = {"m": "http://maven.apache.org/POM/4.0.0"}

    def value(path: str) -> str | None:
        element = root.find(path, ns)
        return element.text.strip() if (
            element is not None and element.text
        ) else None

    return {
        "artifactId": value("m:artifactId"),
        "groupId": value("m:groupId")
                   or value("m:parent/m:groupId"),
        "version": value("m:version")
                   or value("m:parent/m:version"),
        "javaVersion": value(
            "m:properties/m:java.version"
        ),
    }


if __name__ == "__main__":
    mcp.run()
