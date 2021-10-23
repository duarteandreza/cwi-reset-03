### Controller

São as classes, dentro do padrão do `Spring`, responsáveis por criar a camada REST da aplicação. Elas irão permitir que a aplicação seja acessada a partir de uma URL. Você pode criar quantas controllers quiser e, geralmente, cada controller é responsável por um recurso da aplicação. Para criar métodos para acessar os recursos e o Spring poder gerenciá-los, é necessário que suas controllers sigam algumas restrições:

- A classe declarada precisa ser pública
- O método declardo precisa ser público
- A classe deve ter a _anotação_ `@RestController`
- A classe deve ter a _anotação_ `@RequestMapping`
- O método deve ter a _anotação_ `@<verbo>Mapping`, onde verbo é o verbo HTTP desejado para a requisição, porém, em UpperCamelCase:
  - `@GetMapping` - permite que o método seja acessado através de uma chamada HTTP com verbo GET
  - `@PostMapping` - permite que o método seja acessado através de uma chamada HTTP com verbo POST
  - `@PutMapping` - permite que o método seja acessado através de uma chamada HTTP com verbo PUT
  - `@DeleteMapping` - permite que o método seja acessado através de uma chamada HTTP com verbo DELETE

> Anotação é um recurso do Java que permite criar marcações em pontos do código para que outros processos possam interceder no funcionamento natural do código. Funcionam como tags para identificar que o desenvolvedor quer ter um comportamento diferente do normal naquele ponto. Anotações existem no Java independente do Spring. No entanto o Spring faz bastante uso delas para que não seja necessário o desenvolver escrever códigos repetitivos.

As anotações `@RequestMapping` e `@<verbo>Mapping` podem receber parâmetros para identificar o recurso que está sendo alterado. Por exemplo, para acessar o recurso `usuario`, vamos querer uma URL com o padrão:

`http://localhost:8080/usuarios`

Sendo assim, como o `@RequestMapping` identifica o recurso, precisamos informar que o recurso será acessado através do termo `usuario` na URL. Logo, o uso correto, nesse caso, seria `@RequestMapping("usuarios")`. **Prestar atenção na diferença de singular e plurar: o recuro é o "usuario", a identificação dele na url é "usuarios"**

Para acessar um recurso específico, exemplo, o usuário de ID 8, precisamos informar isso na URL. Se estivermos buscando o usuário de ID 8, então precisamos usar o `@GetMapping`, mas como o método irá identificar qual é o usuário buscado? Para isso precisos definir como isso será declarado na URL. Usando o padrão REST, deverá ficar:

`GET http://localhost:8080/usuarios/8`

Para atingir esse objetivo, o `@GetMapping` deverá indicar que a URL depende de uma informação dinâmica, o ID nesse caso. Então precisamos passar isso por parâmetro para a anotação: `@GetMapping("{id}")`. E para, no código, ter acesso a esse id informado na url, o método deverá receber o id por parâmetro também, identificando-o com uma outra anotação: `@PathVariable("id")`.

No final, a classe fica com esse formato:

```java
@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @GetMapping
    public List<Usuario> listarTodosUsuarios() {
        return null;
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable("id") String idUsuario) {
        return null;
    }

}
```

### Service

Dentro das convenções adotadas pelo Spring, "Services" são às classes responsáveis pelas regras de negócio da aplicação. Será nessas classes que ficarão a lógica por trás de cada método HTTP utilizado. Para identificar para o Spring que uma classe se comporta como uma "Service" usamos a anotação `@Service` na classe. Dessa forma:

```java
@Service
public class UsuarioService {

    public List<Usuario> listarTodosUsuarios() {
        System.out.println("Lógica para listar todos os usuarios");
        return null;
    }

    public Usuario cadastrar(Usuario usuario) {
        System.out.println("Aplica as regras para salvar um usuário");
        return null;
    }

}
```

### Repository

Assim como as Services e Controllers, as classes do tipo "Repository" precisam ser identificadas através de uma anotação para que o Spring entenda que essa clase se comporta como um repositório, ou seja, como uma classe que acessa uma base de dados ou qualquer estrutura que permita salvar informações. A anotação utilizada para isso é a `@Repository`, deixando a classe assim:

```java
@Repository
public class UsuarioRepository {

    public List<Usuario> listarTodosUsuarios() {
        System.out.println("Acesso à lista onde serão salvos os usuários");
        return null;
    }

    public Usuario cadastrar(Usuario usuario) {
        System.out.println("Adicionar um usuário à lista pre-exisente");
        return null;
    }

}
```

### Autowired

Anotação indicada para criar relaçães de dependência entre objetos, de forma que o Spring passa a gerenciar quando e como deve ser instanciadas as classes que possuem as anotações `@RestController`, `@Service` e `@Repository`. Atributos com essa anotação não precisam ser instanciados, o Spring faz isso automaticamente:

```java

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository; // não precisa ser instanciado manualmente

    public List<Usuario> listarTodosUsuarios() {
        System.out.println("Lógica para listar todos os usuarios");
        return null;
    }

    public Usuario cadastrar(Usuario usuario) {
        System.out.println("Aplica as regras para salvar um usuário");
        return null;
    }

}

```
