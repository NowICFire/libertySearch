@echo off

set baseDir=%CD%
set srcDir=%baseDir%\src
set libDir=%baseDir%\lib
set outDir=%baseDir%\out

if exist %outDir% rmdir /Q /S %outDir%

if not exist %srcDir% (
    echo src not exist!
    goto END
)
if not exist %libDir% (
    echo lib not exist!
    goto END
)

cd %srcDir%
javac -d %outDir% -cp ".;%libDir%\fastjson-1.2.68.jar;" libertySearch/service/LibertySearch.java

cd %outDir%
jar -cfmv LibertySearch.jar %srcDir%\META-INF\MANIFEST.MF -C . .
move .\LibertySearch.jar %baseDir%

cd %baseDir%
rmdir /Q /S %outDir%

:END
pause
exit
