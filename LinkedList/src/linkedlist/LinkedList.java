/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author John
 */
import java.util.Scanner;

public class LinkedList {

    static Scanner read = new Scanner(System.in);
    static Node PTR = null, base = null;
    static int length = 0, top = -1;

    static void createList() {
        String list;
        System.out.println("Ingrese la lista:");
        list = read.next();
        String[] fields = list.split("-");
        for (String field : fields) {
            if (PTR == null) {
                PTR = new Node(Integer.parseInt(field));
            } else {
                Node p = PTR;
                while (p.getLink() != null) {
                    p = p.getLink();
                }
                p.setLink(new Node(Integer.parseInt(field)));
            }
        }
    }

    static void createOrderList() {
        int op = 1, num;
        Node p = PTR;
        do {
            int sw = 0;
            Node antp = null;
            Node q = null;
            p = PTR;
            System.out.println("Digite info del nodo: ");
            num = read.nextInt();
            q = new Node(num);
            if (PTR == null) {
                PTR = q;
            } else {
                while ((p != null) && (sw == 0)) {
                    if (p.getNum() > q.getNum()) {
                        q.setLink(p);
                        if (antp != null) {
                            antp.setLink(q);
                        } else {
                            PTR = q;
                        }
                        sw = 1;
                    } else if (p.getNum() == q.getNum()) {
                        sw = 2;
                        System.out.println("No puden haber repeticiones");
                    } else {
                        antp = p;
                        p = p.getLink();
                    }
                }
                if (sw == 0) {
                    antp.setLink(q);
                    q.setLink(null);
                }
            }
            System.out.println("Desea ingresar mas nodos 1-Si, 0-No");
            op = read.nextInt();
        } while (op == 1);
    }

    static void deleteNode(int info) {
        Node p = PTR;
        Node antp = null;
        if (PTR != null) {
            while (p.getNum() != info && p.getLink() != null) {
                antp = p;
                p = p.getLink();
                if (p == PTR) {
                    break;
                }
            }
            if (p.getNum() == info) {
                if (p == PTR) {
                    PTR = p.getLink();
                    if (base != null) {
                        base.setLink(PTR);
                    }
                    p.setLink(null);
                } else {
                    if (p == base) {
                        base = p.getLink();
                    }
                    antp.setLink(p.getLink());
                    p.setLink(null);
                }
            } else {
                System.out.println("No se encontro el elemento con la informacion " + info);
            }
        } else {
            System.out.println("Lista vacia!");
        }
    }

    static void setLength() {
        System.out.println("Digite el tama;o de la pila o cola: ");
        length = read.nextInt();
    }

    static void updateLength() {
        if (length == 0) {
            Node q = PTR;
            while (q != null) {
                q = q.getLink();
                if (q == PTR) {
                    break;
                } else {
                    length++;
                }
            }
        }
    }

    static void clean() {
        PTR = null;
        base = null;
    }

    static int getInfo(int position) {
        Node p = PTR;
        for (int i = 0; i < length; i++) {
            if (i == position) {
                return p.getNum();
            }
            p = p.getLink();
        }
        return -404;
    }

    static void createStack() {
        int op, cont = 0;
        boolean sw;
        setLength();
        do {
            System.out.println("Digite info del nodo: ");
            int num = read.nextInt();
            Node p = new Node(num);
            if (PTR == null) {
                PTR = p;
            } else {
                p.setLink(PTR);
                PTR = p;
            }
            cont++;
            System.out.println("Quiere insertar mas nodos 1-Si, 0-No");
            op = read.nextInt();
            sw = (op == 1);
            if (cont == length) {
                System.out.println("Lista llena");
                sw = false;
            }
        } while (sw);
    }

    static void createQueue() {
        int op;
        Node z = PTR;
        boolean sw;
        do {
            System.out.println("Digite info del nodo: ");
            int num = read.nextInt();
            if (z == null) {
                z = new Node(num);
            } else {
                Node q = z;
                while (q.getLink() != null) {
                    q = q.getLink();
                }
                q.setLink(new Node(num));
            }
            System.out.println("Quiere insertar mas nodos 1-Si, 0-No");
            op = read.nextInt();
            sw = (op == 1);
        } while (sw);
        PTR = z;
    } //simple method

    static void addToQueue() {
        PTR = null;
        Node z = PTR;
        for (int i = 0; i < 7; i++) {
            System.out.println("Digite info del nodo: ");
            int num = read.nextInt();
            if (z == null) {
                z = new Node(num);
            } else {
                Node q = z;
                while (q.getLink() != null) {
                    q = q.getLink();
                }
                q.setLink(new Node(num));
            }
        }
        PTR = z;
    } //simple method

    static void createAdvancedQueue() {
        int op, cont = 0;
        boolean sw;
        setLength();
        do {
            System.out.println("Digite info del nodo: ");
            int num = read.nextInt();
            Node p = new Node(num);
            if (PTR == null) {
                PTR = p;
            } else {
                if (base == null) {
                    base = p;
                    PTR.setLink(base);
                } else {
                    base.setLink(p);
                    base = p;
                }
            }
            cont++;
            System.out.println("Quiere insertar mas nodos 1-Si, 0-No");
            op = read.nextInt();
            sw = (op == 1);
            if (cont == length) {
                System.out.println("Cola llena");
                sw = false;
            }
        } while (sw);
        if (base == null) {
            base = PTR;
        } else {
            base.setLink(PTR);
        }
    }

    static void showList(Node PTR) {
        Node q = PTR;
        while (q != null) {
            System.out.print(q.getNum() + "-");
            q = q.getLink();
            if (q == PTR) {
                break;
            }
        }
    }

    static void changePosition() {
        int op, a = 0, b = 0, i = 0;
        do {
            System.out.println("Elemento A: ");
            a = read.nextInt();
            System.out.println("Elemento B: ");
            b = read.nextInt();
        } while (!(a > 0) && !(b > a) && !(b < length));

        Node p = PTR, Antp = null, A = null, AntA = null;
        while (p != null) {
            if (i == a) {
                A = p;
                AntA = Antp;
            } else if (i == b) {
                if (AntA != null) {
                    AntA.setLink(p);
                } else {
                    PTR = p;
                }
                Node Nextp = p.getLink();
                p.setLink(A.getLink());
                Antp.setLink(A);
                A.setLink(Nextp);
                if (Nextp == null || Nextp == PTR) {
                    base = A;
                }
            }
            Antp = p;
            p = p.getLink();
            i++;
            if (p == PTR) {
                break;
            }
        }
    }

    static void exercise() {
        System.out.println("Digite n1: ");
        int n1 = read.nextInt();
        if (n1 < PTR.getNum()) { // positions starts from 0 not from 1 like the example...
            int fixedNumber = 0, number, i = 1; //fix number should starts on 1...
            updateLength(); //real positions to delete, for n1 = 2, are 0,2,4,6,... 
            do {
                deleteNode(getInfo(fixedNumber));
                number = 1 + i * n1;
                fixedNumber = (i * n1) - i;
                i++;
            } while (number <= length);
        } else {
            System.out.println("n1 mayor que el tope!");
        }
    }

    static void inStack(int num) {
        Node p = new Node(num);
        if (PTR == null) {
            PTR = p;
            length++;
        } else {
            if (length < top || top == -1) {
                p.setLink(PTR);
                PTR = p;
                length++;
            }
        }
    }

    static void canStack() {
        if (length != 0) {
            PTR = PTR.getLink();
            length--;
        }
    }

    static void inQueue(int num) {
        Node p = new Node(num);
        if (PTR == null) {
            PTR = p;
            length++;
        } else {
            if (length < top || top == -1) {
                if (base == null) {
                    base = p;
                    PTR.setLink(base);
                } else {
                    base.setLink(p);
                    base = p;
                }
                length++;
            }
        }
    }

    static void canQueue() {
        if (length != 0) {
            PTR = PTR.getLink();
            length--;
        }
    }

    public static void main(String[] args) {
        int op;
        do {
            System.out.println(
                    "Opciones:\n"
                    + "-1. Crear Lista (eficiente)\n"
                    + " 1. Crear Cola\n"
                    + " 2. Crear Pila\n"
                    + " 3. Mostrar Lista\n"
                    + " 4. Eliminar\n"
                    + " 5. Cambiar posicion\n"
                    + " 6. Ejercico 2\n"
                    + " 0. Salir"
            );
            System.out.println("OPCION: ");
            op = read.nextInt();
            System.out.println("");
            switch (op) {
                case -1:
                    clean();
                    System.out.println("Ejemplo de lista: 1-2-3-4");
                    createList();
                    break;
                case 1:
                    clean();
                    createAdvancedQueue();
                    showList(PTR);
                    break;
                case 2:
                    clean();
                    createStack();
                    showList(PTR);
                    break;
                case 3:
                    showList(PTR);
                    break;
                case 4:
                    System.out.println("Digite elemento a eliminar: ");
                    int info = read.nextInt();
                    deleteNode(info);
                    showList(PTR);
                    break;
                case 5:
                    changePosition();
                    showList(PTR);
                    break;
                case 6:
                    exercise();
                    showList(PTR);
                    break;
                default:
                    op = 0;
                    break;
            }
            System.out.println("\n\n");
        } while (op != 0);

    }
}
