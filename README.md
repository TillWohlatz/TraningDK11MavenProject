
# First Step 
    for Windows machines
* Install JDK11
  * URL: https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html
* Install GIT
  * URL: https://github.com/git-for-windows/git/releases/tag/v2.19.1.windows.1
  * Optional: Ensure you have an vaid SSH key-pair in the folder '%UserProfile%\\.ssh\' and copy your public key into your GitHub profile under 'SSH and GPG keys'
  * Clone this repository into an appropirate projects root folder
* Install community version of InelliJ
  * URL: https://www.jetbrains.com/idea/download/#section=windows


# Second Step 
Open the project within the IDE
> execute the maven targets: clean install site -Dmaven.test.failure.ignore=true


To ensure the IDE all dependencies and plugins are loaded from the repositories.
After successful maven build the target/site/ folder should contain the project build and the java doc reports.
