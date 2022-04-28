package tugasBesar;
import java.util.*;

public class tgsBesar {
    static Queue<String> antrian = new PriorityQueue<>();
    static Stack<String> stack = new Stack<>();
    static boolean runAntrian = true;
    static boolean runTiket = true;
    static Scanner input = new Scanner(System.in);

    public static <T extends Comparable<? super T>> void merge(T[] arr, int left, int median, int right) {
        Object[] temp = new Object[arr.length];
        int kiri1, kanan1, kiri2, kanan2, i, j;
        kiri1 = left;
        kanan1 = median;
        kiri2 = median + 1;
        kanan2 = right;
        i = left;
        while ((kiri1 <= kanan1) && (kiri2 <= kanan2)) {
            if (arr[kiri2].compareTo(arr[kiri1]) >= 0) {
                temp[i] = arr[kiri1];
                kiri1++;
            } else {
                temp[i] = arr[kiri2];
                kiri2++;
            }
            i++;
        }
        while (kiri1 <= kanan1) {
            temp[i] = arr[kiri1];
            kiri1++;
            i++;
        }
        while (kiri2 <= kanan2) {
            temp[i] = arr[kiri2];
            kiri2++;
            i++;
        }
        j = left;
        while (j <= right) {
            arr[j] = (T) temp[j];
            j++;
        }
    }

    public static <T extends Comparable<? super T>> void mergeSort(T[] arr, int l, int r) {
        int med;
        if (l < r) {
            med = (l + r) / 2;
            mergeSort(arr, l, med);
            mergeSort(arr, med + 1, r);
            merge(arr, l, med, r);
        }
    }

    public static <T> void tampil(T data[]) {
        for (T objek : data) {
            System.out.print(objek + " ");
        }
        System.out.println("");
    }

    public static void menu() {
        System.out.print("1. Antrian Penumpang\n2. Tumpukan Tiket\n");
        System.out.print("\nMasukkan Pilihan : ");
        int pil = input.nextInt();
        switch (pil) {
            case 1:
                antrian();
                break;
            case 2:
                tiket();
                break;
        }
    }

    public static void antrian() {
        System.out.println("==== Antrian Kereta api ====");
        while (runAntrian) {
            System.out.print("1. Tambah Penumpang\n2. Penumpang Pertama\n3. Hapus Penumpang\n4. Hapus Penumpang Pertama\n5. Lihat Semua Penumpang\n6. Sort Penumpang\n7. Kembali\n8. Berhenti");
            System.out.print("\nMasukkan Pilihan : ");
            int pil = input.nextInt();
            switch (pil) {
                case 1:
                    String p = input.next();
                    antrian.offer(p);
                    break;
                case 2:
                    System.out.println("Penumpang Pertama Adalah : " + antrian.peek());
                    break;
                case 3:
                    String q = input.next();
                    antrian.remove(q);
                    break;
                case 4:
                    System.out.println("Penumpang Pertama Adalah : " + antrian.peek());
                    antrian.poll();
                    break;
                case 5:
                    System.out.println(antrian);
                    break;
                case 6:
                    Object[] arrAntrian = antrian.toArray();
                    Arrays.sort(arrAntrian);
                    System.out.println("Data Sorting : " + antrian);
                    System.out.println(" ");
                    break;
                case 7:
                    menu();
                    break;
                case 8:
                    runAntrian = false;
                    break;
            }
        }
    }

    public static void tiket() {
        while (runTiket) {
            System.out.println("Pilih Menu : ");
            System.out.print("1. Isi Data\n2. Hapus Data terratas\n3. Lihat Data teratas\n4. Search\n5. Semua Data\n6. Kembali\n7. Berhenti\n8. Sort Data\n");
            System.out.println("Pilih Nomor : ");
            int pilih = input.nextInt();
            switch (pilih) {
                case 1:
                    System.out.print("Masukkan input : ");
                    String inputan = input.next();
                    stack.push(inputan);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    System.out.println("data ter atas adalah : " + stack.peek() + "\n");
                    break;
                case 4:
                    System.out.println("Masukkan yang akan Dicari : ");
                    String cari = input.next();
                    int h = stack.search(cari);
                    if (h < 0) {
                        System.out.println("Data Tidak Ditemukan");
                    } else {
                        System.out.println("Data Ditemukan Di Posisi ke - " + h);
                    }
                case 5:
                    System.out.println(stack);
                    break;
                case 6:
                    menu();
                    break;
                case 7:
                    runTiket = false;
                    break;
                case 8:
                    String[] arr = new String[stack.size() - 1];
                    arr = stack.toArray(arr);
                    mergeSort(arr, 0, arr.length - 1);
                    System.out.print("Semua Data : ");
                    tampil(arr);
                    System.out.println(" ");
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}
