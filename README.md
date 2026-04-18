# Mutant

A project integrating Jenkins CI/CD pipelines with Claude Code AI assistance via GitHub Actions.

## Prerequisites

Before running this project locally, make sure you have the following installed:

- [Git](https://git-scm.com/downloads)
- [Jenkins](https://www.jenkins.io/doc/book/installing/) (to run the pipeline locally)
- A GitHub account with access to this repository

## Local Setup

### 1. Clone the Repository

```bash
git clone https://github.com/cmendozat/mutant.git
cd mutant
```

### 2. Run the Jenkins Pipeline Locally

This project uses a `Jenkinsfile` to define the CI pipeline. To run it locally:

1. **Install Jenkins** (if not already installed):
   - Follow the [official Jenkins installation guide](https://www.jenkins.io/doc/book/installing/) for your OS.

2. **Start Jenkins**:
   ```bash
   # On macOS (with Homebrew)
   brew services start jenkins

   # On Linux (systemd)
   sudo systemctl start jenkins

   # Or run directly with Java
   java -jar jenkins.war
   ```

3. **Access Jenkins UI**:
   - Open your browser and go to `http://localhost:8080`
   - Complete the initial setup wizard if this is a fresh installation

4. **Create a new Pipeline job**:
   - Click **New Item** in Jenkins
   - Enter a name for the job and select **Pipeline**
   - Click **OK**

5. **Configure the Pipeline**:
   - Under **Pipeline**, select **Pipeline script from SCM**
   - Set **SCM** to **Git**
   - Enter the repository URL: `https://github.com/cmendozat/mutant.git`
   - Set the **Script Path** to `Jenkinsfile`
   - Click **Save**

6. **Run the Pipeline**:
   - Click **Build Now** to trigger the pipeline
   - The pipeline will execute the stages defined in the `Jenkinsfile`

### 3. Set Up Claude Code Integration (Optional)

This project uses the [Claude Code GitHub Action](https://github.com/anthropics/claude-code-action) to enable AI assistance via `@claude` mentions in issues and pull requests.

To configure this in your own fork:

1. **Add your Anthropic API key** as a GitHub repository secret:
   - Go to your repository **Settings > Secrets and variables > Actions**
   - Click **New repository secret**
   - Name: `ANTHROPIC_API_KEY`
   - Value: Your Anthropic API key from [console.anthropic.com](https://console.anthropic.com)

2. The workflow is defined in `workflows/claude.yml` and triggers automatically on:
   - Issue comments containing `@claude`
   - Pull request review comments containing `@claude`
   - Issues opened or assigned with `@claude` in the body

## Usage

Once set up, you can interact with Claude directly in GitHub issues and pull requests by mentioning `@claude` followed by your request.

**Example:**
```
@claude Can you review this code and suggest improvements?
```

## Project Structure

```
mutant/
├── Jenkinsfile          # Jenkins CI/CD pipeline definition
├── README.md            # Project documentation
└── workflows/
    └── claude.yml       # Claude Code GitHub Actions workflow
```
