@echo off
set ANTLR_JAR=antlr4-4.13.1-complete.jar
set GEN_DIR=FlaskGen

echo ========================================
echo  Flask Compiler - Build Script (Windows)
echo ========================================

echo.
echo [1/3] Generating ANTLR sources...
java -jar "%ANTLR_JAR%" -package FlaskGen -visitor -o "%GEN_DIR%" FlaskLexer.g4 FlaskParser.g4
if %errorlevel% neq 0 (
    echo [ERROR] ANTLR generation failed.
    exit /b %errorlevel%
)
echo [OK] ANTLR generation complete.

echo.
echo [2/3] Compiling Java sources...
if not exist out mkdir out
dir /s /b *.java | findstr /v "\\out\\" | findstr /v "\\.idea\\" > sources.txt
javac -cp ".;%ANTLR_JAR%" -d out @sources.txt
if %errorlevel% neq 0 (
    echo [ERROR] Compilation failed.
    if exist sources.txt del sources.txt
    exit /b %errorlevel%
)
echo [OK] Compilation successful.
if exist sources.txt del sources.txt

echo.
echo [3/3] Running Flask Compiler...
echo ========================================

java -cp "out;%ANTLR_JAR%" Main

echo.
echo ========================================
echo  Build Finished Successfully
echo ========================================
