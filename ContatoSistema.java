import java.util.ArrayList;
import java.util.List;

class Telefone {
    private String numero;
    private String rotulo;

    public Telefone(String numero, String rotulo) {
        this.numero = numero;
        this.rotulo = rotulo;
    }

    public String getNumero() {
        return numero;
    }

    public String getRotulo() {
        return rotulo;
    }

    @Override
    public String toString() {
        return rotulo + ": " + numero;
    }
}

class Email {
    private String endereco;
    private String rotulo;

    public Email(String endereco, String rotulo) {
        this.endereco = endereco;
        this.rotulo = rotulo;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getRotulo() {
        return rotulo;
    }

    @Override
    public String toString() {
        return rotulo + ": " + endereco;
    }
}

class Contato {
    private String nome;
    private List<Telefone> telefones;
    private List<Email> emails;

    public Contato(String nome) {
        this.nome = nome;
        this.telefones = new ArrayList<>();
        this.emails = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarTelefone(Telefone telefone) {
        telefones.add(telefone);
    }

    public void removerTelefone(String numero) {
        telefones.removeIf(t -> t.getNumero().equals(numero));
    }

    public void adicionarEmail(Email email) {
        emails.add(email);
    }

    public void removerEmail(String endereco) {
        emails.removeIf(e -> e.getEndereco().equals(endereco));
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public List<Email> getEmails() {
        return emails;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("Telefones:\n");
        for (Telefone t : telefones) {
            sb.append("  ").append(t).append("\n");
        }
        sb.append("Emails:\n");
        for (Email e : emails) {
            sb.append("  ").append(e).append("\n");
        }
        return sb.toString();
    }
}

class Agenda {
    private List<Contato> contatos;

    public Agenda() {
        this.contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    public void removerContato(String nome) {
        contatos.removeIf(c -> c.getNome().equals(nome));
    }

    public Contato buscarContato(String nome) {
        for (Contato c : contatos) {
            if (c.getNome().equals(nome)) {
                return c;
            }
        }
        return null;
    }

    public void listarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("Agenda vazia.");
        } else {
            for (Contato c : contatos) {
                System.out.println(c);
            }
        }
    }
}

//exemplo de uso
public class ContatoSistema {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        Contato contato1 = new Contato("João Silva");
        contato1.adicionarTelefone(new Telefone("1234-5678", "Casa"));
        contato1.adicionarTelefone(new Telefone("9876-5432", "Trabalho"));
        contato1.adicionarEmail(new Email("joao.silva@email.com", "Pessoal"));
        contato1.adicionarEmail(new Email("joao.silva@empresa.com", "Trabalho"));

        agenda.adicionarContato(contato1);

        Contato contato2 = new Contato("Maria Oliveira");
        contato2.adicionarTelefone(new Telefone("5555-5555", "Celular"));
        contato2.adicionarEmail(new Email("maria.oliveira@email.com", "Pessoal"));

        agenda.adicionarContato(contato2);

        System.out.println("Contatos na Agenda:");
        agenda.listarContatos();

        System.out.println("\nRemovendo contato João Silva...");
        agenda.removerContato("João Silva");

        System.out.println("\nContatos na Agenda após remoção:");
        agenda.listarContatos();

        Contato contatoBuscado = agenda.buscarContato("Maria Oliveira");
        if (contatoBuscado != null) {
            System.out.println("\nContato encontrado:\n" + contatoBuscado);
        } else {
            System.out.println("\nContato não encontrado.");
        }
    }
}
