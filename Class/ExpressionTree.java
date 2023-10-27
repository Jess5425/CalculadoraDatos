package Class;

public class ExpressionTree {
    NodoArbol root;
    NodoArbol left;
    NodoArbol right;

    public StringArray operators;
    public StringArray opLogicos;
    //Lista expresion; // x+(y-z)
    Pila operandoStack;


    public ExpressionTree(NodoArbol a) {
        this.root = a;
        this.left = null;
        this.right = null;
    }

    public ExpressionTree() {
        this.root = null;
        this.left = null;
        this.right = null;

        this.operators = new StringArray(6); // Initialize operators array
        this.opLogicos = new StringArray(4); // Initialize opLogicos array
        this.operandoStack = new Pila();

        // Populate the arrays
        operators.insertAll("+", "-", "*", "/", "%", "**");
        opLogicos.insertAll("&", "|", "^", "~");
    }

    private void evalue(Lista caracteres) {
        System.out.println("evalue");
        Lista nodosOperandos = procesarParentesis(caracteres);
        creaArbol(nodosOperandos);
    }

    private NodoArbol creaArbol(Lista caracteres) {
        System.out.println("creaArbol");
        //llamo procesaParentesis, me da una lista
        Lista sinParentesis = procesarParentesis(caracteres);
        //llamo procesaCaracteres en la lista
        Lista sinOperandos = procesaCaracteres(sinParentesis);
        //Tomo lista de operadores y hago el árbol
        NodoArbol resultNode = operatorHandler(sinOperandos);


        // Assuming you have a way to get the root node of the tree
        return resultNode;  // Replace rootNode with the actual root node
    }


    private Boolean isOperator(StringArray conjunto, NodoArbol c) { //Método que revisa si es operator
        System.out.println(c.data);
        for (int i = 0; i < conjunto.getSize(); i++) {
            if (conjunto.get(i).equals(c.data)) {
                return true;
            }
        }
        return false;
    }

    private Lista procesaCaracteres(Lista listaParentesis) {
        NodoArbol c = listaParentesis.getFirst();
        Lista soloOperator = new Lista();

        while (c != null) {

            if (!isOperator(operators, c)) {

                operandoStack.push(c);

            }
            if (isOperator(operators, c)) {
                soloOperator.insertNode(c);
            }
            c = c.next;
        }

        return soloOperator;
    }





    private NodoArbol operatorHandler(Lista listaOperando) {
        NodoArbol op = listaOperando.getLast();
        NodoArbol resultNode = new NodoArbol();

        while (op.prev!=null){
            constructor(op);
            operandoStack.push(op);
        }
        resultNode.data = op.data;
        resultNode.left = operandoStack.pop();
        resultNode.right = operandoStack.pop();
        return resultNode;

    }

    private void constructor(NodoArbol op) {
        op.right = operandoStack.pop();
        op.left = operandoStack.pop();
    }


    private Lista procesarParentesis(Lista expresion) {

        System.out.println("procesarParentesis");
        NodoArbol current = expresion.getFirst();
        NodoArbol start = null;
        NodoArbol end = null;
        int count=0;

        // Itera a través de los nodos de la expresión
        while (current != null) {
            System.out.println("while current!=null");
            System.out.println("current = "+ current.data);
            if (start!=null){
                System.out.println("start = " + start.data);
            }
            if (current.data.equals("(")) {  // Si el nodo actual es un paréntesis abierto:
                start = current;// Marca este nodo como el inicio del paréntesis.
                count++;
            } else if (current.data.equals(")")) {  // Si el nodo actual es un paréntesis cerrado:
                end = current;  // Marca este nodo como el fin del paréntesis.
                count--;
                break;
            }
            current = current.next;
        }

        // Si se encontraron un par de paréntesis válido
        if (start != null && end != null) {
            System.out.println("encuentra par de parentesis ");
            // Extrae la subexpresión entre los paréntesis
            Lista subExpression = extractSubexpression(start, end);
            //subExpression.display();

            // Crea un árbol de expresión para la subexpresión

            NodoArbol subArbol = creaArbol(subExpression);


            // Si el paréntesis estaba al inicio de la expresión
            if (start == expresion.getFirst()) {
                expresion.insertNode(subArbol);  // Inserta la subexpresión en la lista original.
            } else {
                // Encuentra el nodo anterior al inicio de la subexpresión
                NodoArbol previous = getPrevious(expresion.getFirst(), start);
                previous.next = subArbol;  // Conecta el nodo anterior al inicio de la subexpresión.
            }

            // Conecta el último nodo de la subexpresión al siguiente después del paréntesis cerrado
            subExpression.getLast().next = end.next;

            // Si hay un nodo después del paréntesis cerrado
            if (end.next != null) {
                end.next.prev = subExpression.getLast();  // Conecta el nodo siguiente al anterior de la subexpresión.
            }

            // Llamada recursiva para procesar más paréntesis.
            if (count!=0){
                return procesarParentesis(expresion);
            }
            // AQUI ESTÁ EL ERROR DEL LOOP PARENTESIS
        }

        return expresion;  // Retorna la lista de expresión actualizada.
    }

    public Lista extractSubexpression(NodoArbol start, NodoArbol end) {
        Lista subexpressionList = new Lista();
        NodoArbol current = start.next; // Skip the first character (opening parenthesis)

        while (current != null && current != end) {
            NodoArbol newNode = new NodoArbol();
            newNode.data = current.data;
            subexpressionList.insertNode(newNode);
            current = current.next;
        }

        if (current == null) {
            System.out.println("Error: End node not found in the list.");
            return null; // Handle this case based on your application's requirements
        }

        return subexpressionList;
    }





    private NodoArbol getPrevious(NodoArbol current, NodoArbol target) {
        System.out.println("getPrev");
        while (current != null && current.next != target) {
            current = current.next;
        }
        return current;
    }

    public void printTree(NodoArbol node, int depth) {
        System.out.println("printTree");
        if (node != null) {
            printTree(node.right, depth + 1);
            System.out.println("   ".repeat(depth) + node.data);
            printTree(node.left, depth + 1);
        }
    }

    public void evalueLista(Lista list){
        evalue(list);
    }

}