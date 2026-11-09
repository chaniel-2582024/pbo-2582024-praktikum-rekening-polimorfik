public abstract class Rekening {
    private String nomor;
    private String pemilik;
    protected int saldo;

    public Rekening(String nomor, String pemilik, int saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    public String getNomor() {
        return nomor;
    }

    public String getPemilik() {
        return pemilik;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setor(int jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
        }
    }

    public boolean tarik(int jumlah) {
        if (jumlah > 0 && jumlah <= saldo) {
            saldo -= jumlah;
            return true;
        }
        return false;
    }

    // Wajib ditulis ulang oleh Tabungan dan Giro
    public abstract int biayaAdminBulanan();

    // Method biasa (konkret): potong saldo, lalu kembalikan besar biayanya
    public int potongBiayaAdmin() {
        int biaya = biayaAdminBulanan();
        saldo -= biaya;
        return biaya;
    }

    // Mengubah angka jadi format Rp1.000.000
    protected static String formatRupiah(int angka) {
        String hasil = String.format(java.util.Locale.US, "%,d", Math.abs(angka)).replace(',', '.');
        if (angka < 0) {
            return "-Rp" + hasil;
        }
        return "Rp" + hasil;
    }

    public void cetakInfo() {
        System.out.println(nomor + " | " + String.format("%-6s", pemilik) + " | " + formatRupiah(saldo));
    }
}