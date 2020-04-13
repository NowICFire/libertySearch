@echo off
REM close echo

%~d0
cd "%~dp0"
REM enter the dir where this script

set "result="
REM set the result variable for splicing keywords

:loop
REM enter loop

if "%1"=="" (
    goto end
    REM exit loop when current param is null
) else (
    set "result=%result%%1 "
    REM splicing keywords
    shift
    REM iteration

    goto loop
)

:end
REM exit loop

set PATH=%PATH%;%~dp0lnk

java -jar bin/${project.build.finalName}.jar %result%
REM call java program
