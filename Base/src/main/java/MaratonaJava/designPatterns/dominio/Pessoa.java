package MaratonaJava.designPatterns.dominio;

public class Pessoa {
    private String firstName;
    private String lastName;
    private String username;
    private String email;

    private Pessoa(String firstName, String lastName, String username, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


    public static final class PessoaBuilder {
        private String firstName;
        private String lastName;
        private String username;
        private String email;

        public PessoaBuilder() {

        }

        public PessoaBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PessoaBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PessoaBuilder username(String username) {
            this.username = username;
            return this;
        }

        public PessoaBuilder email(String email) {
            this.email = email;
            return this;
        }

        public Pessoa build() {
            return new Pessoa(firstName, lastName, username, email);
        }
    }
}
