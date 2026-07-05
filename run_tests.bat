@echo off
setlocal

echo ========================================
echo  Flask Compiler - Test Runner
echo ========================================

echo.
echo [1] Build valid sample
call build.bat
if %errorlevel% neq 0 (
    echo [FAIL] Valid sample build failed.
    exit /b %errorlevel%
)
echo [OK] Valid sample build finished.

echo.
echo [2] Check generated Flask syntax
python -m py_compile generated_components\app.py
if %errorlevel% neq 0 (
    echo [FAIL] Generated Flask syntax check failed.
    exit /b %errorlevel%
)
echo [OK] Generated Flask syntax is valid.

echo.
echo [3] Run semantic errors sample
java -cp "out;antlr4-4.13.1-complete.jar" Main samples\sample_semantic_full.txt > semantic_test_output.tmp 2>&1
findstr /C:"Semantic Errors (10)" semantic_test_output.tmp >nul
if %errorlevel% neq 0 (
    type semantic_test_output.tmp
    del semantic_test_output.tmp
    echo [FAIL] Expected Semantic Errors count 10.
    exit /b 1
)
findstr /C:"Code generation skipped because semantic errors were found." semantic_test_output.tmp >nul
if %errorlevel% neq 0 (
    type semantic_test_output.tmp
    del semantic_test_output.tmp
    echo [FAIL] Semantic errors did not skip code generation.
    exit /b 1
)
del semantic_test_output.tmp
echo [OK] Semantic sample reported Semantic Errors count 10 and skipped generation.

echo.
echo [4] Run syntax errors sample
java -cp "out;antlr4-4.13.1-complete.jar" Main samples\sample_syntax_error.txt > syntax_test_output.tmp 2>&1
findstr /C:"Syntax Errors (1)" syntax_test_output.tmp >nul
if %errorlevel% neq 0 (
    type syntax_test_output.tmp
    del syntax_test_output.tmp
    echo [FAIL] Expected Syntax Errors count 1.
    exit /b 1
)
findstr /C:"Code generation skipped because syntax errors were found." syntax_test_output.tmp >nul
if %errorlevel% neq 0 (
    type syntax_test_output.tmp
    del syntax_test_output.tmp
    echo [FAIL] Syntax errors did not skip code generation.
    exit /b 1
)
del syntax_test_output.tmp
echo [OK] Syntax sample reported Syntax Errors count 1 and skipped generation.

echo.
echo [5] Flask smoke test
python generated_components_smoke_test.py
if %errorlevel% neq 0 (
    echo [FAIL] Flask smoke test failed.
    exit /b %errorlevel%
)

echo.
echo All checks finished.
endlocal
