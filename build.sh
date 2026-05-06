#!/bin/bash

ANTLR_JAR="antlr4-4.13.1-complete.jar"
GEN_DIR="FlaskGen"
SAMPLE="samples/sample.txt"
# SAMPLE="samples/sample_basic.txt"
# SAMPLE="samples/sample_routes_nav.txt"
# SAMPLE="samples/sample_for_loop.txt"
# SAMPLE="samples/sample_if_else.txt"
# SAMPLE="samples/sample_methods_post.txt"
# SAMPLE="samples/sample_extends_include_set.txt"
# SAMPLE="samples/sample_errors.txt"

echo "========================================"
echo " Flask Compiler - Build Script"
echo "========================================"

# Step 1: Generate ANTLR parser/lexer
echo ""
echo "[1/3] Generating ANTLR sources..."
java -jar "$ANTLR_JAR" -package FlaskGen -visitor -o "$GEN_DIR" FlaskLexer.g4 FlaskParser.g4
echo "✓ ANTLR generation complete"

# Step 2: Compile all Java sources in correct order
echo ""
echo "[2/3] Compiling Java sources..."
mkdir -p out

# Collect all java files
JAVA_FILES=$(find . -name "*.java" \
    -not -path "./out/*" \
    -not -path "./.idea/*")

# Compile with ANTLR jar in classpath (use semicolon separator for Windows Git Bash)
javac -cp ".:$ANTLR_JAR" -d out $JAVA_FILES 2>&1

if [ $? -eq 0 ]; then
    echo "✓ Compilation successful"
else
    echo ""
    echo "Trying Windows classpath separator..."
    javac -cp ".;$ANTLR_JAR" -d out $JAVA_FILES 2>&1
    if [ $? -eq 0 ]; then
        echo "✓ Compilation successful"
    else
        echo "✗ Compilation failed"
        exit 1
    fi
fi

# Step 3: Run the compiler
echo ""
echo "[3/3] Running Flask Compiler..."
echo "========================================"

# Try both classpath separators
java -cp "out:$ANTLR_JAR" Main "$SAMPLE" 2>/dev/null || \
java -cp "out;$ANTLR_JAR" Main "$SAMPLE"

echo ""
echo "========================================"
echo " Build Finished Successfully"
echo "========================================"
