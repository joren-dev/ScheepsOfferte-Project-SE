# SheepsOfferte-Project-SE
Creates and manages invoices for www.42.nl


For a detailed guide on how to use this program from a user's perspective please take a look at our [User Guide](https://github.com/joren-dev/ScheepsOfferte-Project-SE/tree/main/docs/user%20guide). If you'd like to get a good gist of the code structure, please refer to our UML Diagram that can be found right below.

![UML class diagram example](https://raw.githubusercontent.com/joren-dev/ScheepsOfferte-Project-SE/main/docs/uml%20diagram/program_diagram.jpg)

## Prerequisites
1. Install [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/), with the following options:
	- Language: Java
	- JDK Version: 11 or above
	- Build System: IntelliJ
2. Install [Git Bash](https://gitforwindows.org/) (for windows), alternatively use: Windows Powershell or CMD.


## How to contribute to this project
Down here youll find a detailed guide on how to get started with writing code for this project.


#### 1. How to clone the repository
1. Open Git Bash and redirect to the folder you wish to export the project to locally.
2. Use the `git clone https://github.com/joren-dev/ScheepsOfferte-Project-SE.git` and wait till it finishes.
	- Test connection with remote repo with: `git status`.
3. Open the project folder inside IntelliJ, and try to run the code.

#### 2. How to create a new branch
1. Switch to main branch: `git checkout main`
2. Ensure local branch is up to date: `git pull`
3. Create new branch: `git checkout -b branch_name`. Make sure to name the branch according to its purpose.

#### 3. How to commit to branch
1. Start writing a base for your new branch, when ready continue the steps
2. Add all untracked changes: `git add .`
3. List the changes, and double check if correct: `git status`
4. Commit the changes: `git commit -m "tag: useful short commit info"`, find more about tags [here](link_wiki_here).
5. Push the changes to remote branch: `git push`

#### 4. How to merge branch
1. Go to the branch you wish to be merged with another one: `git checkout branch_merged_into_current`
2. Use command: `git merge branch_merged_into_current -m "merge: useful merge message"`


## Common dev-commands explained
### 1. Make text strong
1. Put this in front of your string: `\033[1m`
2. Put this after your string: `\033[0m`

Example: `System.out.println("\033[1mtekst\033[0m");`
