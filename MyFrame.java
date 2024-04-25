import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;


public class MyFrame extends JFrame implements ActionListener {
    JLabel label, name, surname, born, prov, definitivo;
    JButton reset, calc;
    JTextField nome, cognome, luogoNascita, provincia;

    String[] sex = {"M", "F"};

    String[] year = {"1900", "1901", "1902", "1903", "1904", "1905", "1906", "1907", "1908", "1909", "1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024" };

    String[] month = {"Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno", "Luglio", "Agosto", "Settembre", "Ottobre", "Novembre", "Dicembre"};

    String[] day = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};

    JComboBox sesso = new JComboBox(sex);
    JComboBox anno = new JComboBox(year);
    JComboBox mese = new JComboBox(month);
    JComboBox giorno = new JComboBox(day);


    public static void main(String[] args) {
      MyFrame frame = new MyFrame("codice fiscale", 600, 500);
    }

    public MyFrame(String titolo, int larghezza, int altezza) {
        super(titolo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setSize(larghezza, altezza);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        name = new JLabel(" NOME:");
        add(name, gbc);
        gbc.gridx = 1;
        nome = new JTextField("", 15);
        add(nome, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        surname = new JLabel("COGNOME:");
        add(surname, gbc);
        gbc.gridx = 1;
        cognome = new JTextField("", 15);
        add(cognome, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        born = new JLabel("LUOGO DI NASCITA:");
        add(born, gbc);
        gbc.gridx = 1;
        luogoNascita = new JTextField("", 15);
        add(luogoNascita, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        prov = new JLabel("PROVINCIA:");
        add(prov, gbc);
        gbc.gridx = 1;
        provincia = new JTextField(" ", 15);
        add(provincia, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("SESSO:"), gbc);
        gbc.gridx = 1;
        add(sesso, gbc);
        
        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("ANNO DI NASCITA:"), gbc);
        gbc.gridx = 1;
        add(anno, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("MESE DI NASCITA:"), gbc);
        gbc.gridx = 1;
        add(mese, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("GIORNO DI NASCITA:"), gbc);
        gbc.gridx = 1;
        add(giorno, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1; 
        reset = new JButton("Reset");
        add(reset, gbc);

        gbc.gridx++; 
        calc = new JButton("Calcola");
        add(calc, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2; 
        definitivo = new JLabel("CODICE FISCALE:");
        add(definitivo, gbc);

        sesso.addActionListener(this);
        anno.addActionListener(this);
        mese.addActionListener(this);
        giorno.addActionListener(this);
        reset.addActionListener(this);
        calc.addActionListener(this);

        setVisible(true);
    } 

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reset) {

            sesso.setSelectedIndex(0);
            anno.setSelectedIndex(0);
            mese.setSelectedIndex(0);
            giorno.setSelectedIndex(0);
            nome.setText("");
            cognome.setText("");
            luogoNascita.setText("");
            provincia.setText("");
            definitivo.setText("CODICE FISCALE: ");

        } else if (e.getSource() == calc) {
            
            String nomeUtente = nome.getText();
            String cognomeUtente = cognome.getText();
            String luogoNascitaUtente = luogoNascita.getText();
            String provinciaUtente = provincia.getText();
            String sessoUtente = (String) sesso.getSelectedItem();
            String annoNascitaUtente = (String) anno.getSelectedItem();
            String giornoNascitaUtente = (String) giorno.getSelectedItem();
            int[] dataNascita = {Integer.parseInt(giornoNascitaUtente), mese.getSelectedIndex() + 1, Integer.parseInt(annoNascitaUtente)};
    
            // Calcola il codice fiscale
            String risultato = calcolaCodiceFiscale(nomeUtente, cognomeUtente, sessoUtente, luogoNascitaUtente, provinciaUtente, dataNascita);
            System.out.println("Il codice fiscale è: " + risultato);
            definitivo.setText("CODICE FISCALE:     " + risultato);
        }
    }
    
    
    


    public static String calcolaCodiceFiscale(String nome, String cognome, String sesso, String luogoNascita, String provincia, int[] dataNascita) {
        String codiceAnagrafico = calcolaCodiceAnagrafico(nome, cognome, dataNascita, sesso);
        luogoNascita = luogoNascita.toUpperCase();
        String codiceLuogoNascita = calcolaCodiceLuogoNascita(luogoNascita);
        String codiceFiscale = codiceAnagrafico + codiceLuogoNascita;
        char carattereControllo = calcolaCarattereControllo(codiceFiscale);
        codiceFiscale += carattereControllo;
        return codiceFiscale;
    }


    //questo metodo calcola i primi 15 caratteri del codice fiscale (cognome, nome, anno mese e giorno di nascita)
    public static String calcolaCodiceAnagrafico(String nome, String cognome, int[] dataNascita, String sesso) {
        String cognomeCodice = calcolaCodiceCognome(cognome);
        String nomeCodice = calcolaCodiceNome(nome);
        //prendo le ultime 2 cifre dell'anno di nascita
        String annoNascita = String.format("%02d", dataNascita[2] % 100);
        //ogni mese a una lettera associata
        String[] mesiCodice = {"A", "B", "C", "D", "E", "H", "L", "M", "P", "R", "S", "T"};
        String meseNascita = mesiCodice[dataNascita[1] - 1];
        int giornoNascita = dataNascita[0];
        //per le donne si aggiunge 40 al giorno della nascita
        if (sesso.equalsIgnoreCase("F")) {
            giornoNascita += 40;
        }
        String giornoNascitaCodice = String.format("%02d", giornoNascita);
        return cognomeCodice + nomeCodice + annoNascita + meseNascita + giornoNascitaCodice;
    }

    //metodo che calcola le 3 lettere del cognome prendendo le prime 3 consonanti e altre eccezioni
    public static String calcolaCodiceCognome(String Cognome) {
        Cognome = Cognome.toUpperCase();
        String consonanti = "";
        String vocali = "";
    
        //creo della stringhe con le vocali e leconsonanti del nome
        for (char carattere : Cognome.toCharArray()) {
            if (Character.isLetter(carattere)) {
                if ("AEIOU".indexOf(carattere) != -1) {
                    vocali += carattere;
                } else {
                    consonanti += carattere;
                }
            }
        }

        //System.out.println(consonanti);
    
        String codice = "";
        if (consonanti.length() >= 3) {
            codice = "" + consonanti.charAt(0) + consonanti.charAt(1) + consonanti.charAt(2);
        }else{
            int numVocaliToAdd = 3 - codice.length();
            for (char vocale : vocali.toCharArray()) {
                if (numVocaliToAdd > 0) {
                    codice += vocale;
                    numVocaliToAdd--;
                } else {
                    break;
                }
            }
        }
        //System.out.println(codice);
        return codice;
    }

    //metodo che calcola le 3 lettere del cognome prendendo la prima, la terza e la quarta consonante e altre eccezioni
    public static String calcolaCodiceNome(String nome) {
        nome = nome.toUpperCase();
        String consonanti = "";
        String vocali = "";
    
        for (char carattere : nome.toCharArray()) {
            if (Character.isLetter(carattere)) {
                if ("AEIOU".indexOf(carattere) != -1) {
                    vocali += carattere;
                } else {
                    consonanti += carattere;
                }
            }
        }

        //System.out.println(consonanti);
    
        String codice = "";
        if (consonanti.length() > 3) {
            codice = "" + consonanti.charAt(0) + consonanti.charAt(2) + consonanti.charAt(3);
        }else if (consonanti.length()==3) {
            codice += consonanti;
        }else{
            codice += consonanti;
            int numVocaliToAdd = 3 - codice.length();
            for (char vocale : vocali.toCharArray()) {
                if (numVocaliToAdd > 0) {
                    codice += vocale;
                    numVocaliToAdd--;
                } else {
                    break;
                }
            }
        }
        //System.out.println(codice);
        return codice;
    }
    

    
    public static String calcolaCodiceLuogoNascita(String luogoNascita) {
        
        String filePath = new File("C:\\Users\\aless\\Desktop\\java\\scuola\\altri\\CODICI\\codici.csv").getAbsolutePath();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",,");
                String comuneRiga = columns[0];
                String codice = columns[1];

                if (comuneRiga.equals(luogoNascita)) {
                    return codice;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Z999";
    }

    public static char calcolaCarattereControllo(String codiceFiscaleParziale) {
        int sommaPari = 0;
        int sommaDispari = 0;
    
        // Conversione dei caratteri con posizione di ordine pari
        for (int i = 1; i < 15; i += 2) {
            char carattere = codiceFiscaleParziale.charAt(i);
            int valore = convertiCaratterePari(carattere);
            sommaPari += valore;
        }
    
        // Conversione dei caratteri con posizione di ordine dispari
        for (int i = 0; i < 15; i += 2) {
            char carattere = codiceFiscaleParziale.charAt(i);
            int valore = convertiCarattereDispari(carattere);
            sommaDispari += valore;
        }
    
        // Calcolo del totale e del resto della divisione per 26
        int totale = sommaPari + sommaDispari;
        int resto = totale % 26;
    
        // Conversione del resto nel carattere alfabetico corrispondente
        char carattereControllo = (char) ('A' + resto);
    
        return carattereControllo;
    }
    

    public static int convertiCaratterePari(char carattere) {
        switch (Character.toUpperCase(carattere)) {
            case 'A': case '0': return 0;
            case 'B': case '1': return 1;
            case 'C': case '2': return 2;
            case 'D': case '3': return 3;
            case 'E': case '4': return 4;
            case 'F': case '5': return 5;
            case 'G': case '6': return 6;
            case 'H': case '7': return 7;
            case 'I': case '8': return 8;
            case 'J': case '9': return 9;
            case 'K': return 10;
            case 'L': return 11;
            case 'M': return 12;
            case 'N': return 13;
            case 'O': return 14;
            case 'P': return 15;
            case 'Q': return 16;
            case 'R': return 17;
            case 'S': return 18;
            case 'T': return 19;
            case 'U': return 20;
            case 'V': return 21;
            case 'W': return 22;
            case 'X': return 23;
            case 'Y': return 24;
            case 'Z': return 25;
            default: return 0; 
        }
    }
    
    public static int convertiCarattereDispari(char carattere) {
        switch (Character.toUpperCase(carattere)) {
            case 'A': case '0': return 1;
            case 'B': case '1': return 0;
            case 'C': case '2': return 5;
            case 'D': case '3': return 7;
            case 'E': case '4': return 9;
            case 'F': case '5': return 13;
            case 'G': case '6': return 15;
            case 'H': case '7': return 17;
            case 'I': case '8': return 19;
            case 'J': case '9': return 21;
            case 'K': return 2;
            case 'L': return 4;
            case 'M': return 18;
            case 'N': return 20;
            case 'O': return 11;
            case 'P': return 3;
            case 'Q': return 6;
            case 'R': return 8;
            case 'S': return 12;
            case 'T': return 14;
            case 'U': return 16;
            case 'V': return 10;
            case 'W': return 22;
            case 'X': return 25;
            case 'Y': return 24;
            case 'Z': return 23;
            default: return 0; 
        }
    }
    
}




