package MaratonaJava.designPatterns.dominio;

public class PessoaFactory {
    private String firstName;
    private String lastName;
    private String username;
    private String email;

    private PessoaFactory(String firstName, String lastName, String username, String email) {
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

//builder
    public static final class PessoaFactoryBuilder {
        private String firstName;
        private String lastName;
        private String username;
        private String email;

        private PessoaFactoryBuilder() {
        }

        public static PessoaFactoryBuilder builder() {
            return new PessoaFactoryBuilder();
        }

        public PessoaFactoryBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PessoaFactoryBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PessoaFactoryBuilder username(String username) {
            this.username = username;
            return this;
        }

        public PessoaFactoryBuilder email(String email) {
            this.email = email;
            return this;
        }

        public PessoaFactory build() {
            return new PessoaFactory(firstName, lastName, username, email);
        }
    }
}
