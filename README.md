- [Installation](#installation)
- [Import RM2PT Project](#import-rm2pt-project)
- [Generate Process Model](#generate-process-model)
- [Generate Execution Script](#generate-execution-script)
- [Requirement Validation](#requirement-validation)

# Installation

Firstly, you need to Download and install RM2PT(https://rm2pt.github.io/) and InputGen(https://rm2pt.github.io/advs/inputgen/).

* Click "Help" -> "Install New Software".

![Install New Software](figure/1.png)

* Online Installer
  * Click "Add", input the "Name" (it can be any) and the "Location", then click "Add".
  
  ![Add Repository](figure/2.png)

* Offline Installer
  * Download the package from https://github.com/RM2PT/ValidGen-UpdateSite/releases/download/v1.0.0/ValidGen.jar

  * Click "Add", input the "Name" (it can be any) and Click "Archive".

  * Select the Package you just downloaded.

   ![offline](figure/8.png)


* Choose "ValidGen" and click "Next".

![Install](figure/3.png)

* Click "Next" -> "Finish".

![Install2](figure/4.png)

![Install3](figure/5.png)

* Wait for Complete.
* Click "Install anyway" and Restart RM2PT.

![Install4](figure/6.png)

![Install5](figure/7.png)

* Click "Window" -> "Preferences".

![Config1](figure/11.png)

*Input the Api-Key and Click "Apply and Close".

![Config2](figure/12.png)

* Download the agent [service](https://github.com/maple-fans/ValidGen-Release/releases/download/Release/ValidGen_Agent.zip), unzip it, and run "ValidGen.exe."

# Import RM2PT Project

* Click "File" -> "Open Projects from File System".

![Import1](figure/9.png)

* Click "Directory" and select the project folder, then click "Finish".

![Import2](figure/10.png)

# Generate Process Model

* Right-Click Requirements Model(*.remodel) and Click "RM2PT-Dev" -> "
ValidGen" -> "Generate Process Model".

![Process1](figure/13.png)

* Check and Modify the Prompt.

![Process2](figure/14.png)

* Wait for complete and open diagram automaticlly.

![Process3](figure/15.png)

# Generate Execution Script

* Right-Click Requirements Model(*.remodel) and Click "RM2PT" -> "
OO Prototype" -> "Generate Desktop Prototype".

![ValidGen1](figure/16.png)

* Click "Next" -> "Finish".

![ValidGen2](figure/17.png)

![ValidGen3](figure/18.png)

* Right-Click Requirements Model(*.remodel) and Click "RM2PT-Dev" -> "InputGen".

![ValidGen4](figure/19.png)

* Right-Click Requirements Model(*.remodel) and Click "RM2PT-Dev" -> "ValidGen" -> "Generate Validation Script".

![ValidGen4](figure/20.png)

* Check the Configuration and Click Finish.

![ValidGen4](figure/21.png)

* Check and Modify the Prompt if presented.

* Wait for complete.

![ValidGen5](figure/22.png)




# Requirement Validation
* Right-Click Prototype Project -> "Run As" -> "Maven test".
![Run1](figure/23.png)
