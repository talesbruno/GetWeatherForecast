# GetWeatherForecast
GetWeatherForecast é um aplicativo de previsão do tempo desenvolvido em [kotlin](https://kotlinlang.org/) que utiliza os poderosos componentes de arquitetura do Android e o padrão MVVM (Model-View-ViewModel) com uma arquitertura limpa para fornecer aos usuários informações meteorológicas precisas provenientes da API [OpenWeather](https://openweathermap.org/). Para a interface do usuário, ele usa o Jetpack Compose, o kit de ferramentas moderno do Android para criar uma interface do usuário nativa.

<img src="https://github.com/talesbruno/GetWeatherForecast/assets/105746645/46914d26-9125-48d4-a4ce-01cc85bc74f4" width="200">
<img src="https://github.com/talesbruno/GetWeatherForecast/assets/105746645/dce6c358-7654-4f7b-b338-b7ad8abbe4fd" width="200">
<img src="https://github.com/talesbruno/GetWeatherForecast/assets/105746645/bf66148e-c24c-43d3-8e73-57024d03e52a" width="200">

## Componentes da arquitetura do Android:
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel).
  * GetWeatherForecast usa o componente ViewModel dos componentes de arquitetura do Android para gerenciar e armazenar dados relacionados à interface do usuário de maneira consciente do ciclo de vida. Isso garante que os dados persistam nas alterações de configuração e sejam facilmente acessíveis aos componentes da interface do usuário.
## Injeção de dependência:
* [Injeção de dependências com o Hilt](https://developer.android.com/training/dependency-injection/hilt-android).
  * O aplicativo utiliza a injeção de dependência com o Hilt, uma biblioteca recomendada pelo Android para facilitar a configuração e a resolução de dependências. O Hilt simplifica a criação e o gerenciamento de objetos necessários em diferentes partes do aplicativo, tornando o desenvolvimento mais eficiente e organizado.
## Programação assíncrona:
* [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html).
* [Asynchronous Flow](https://kotlinlang.org/docs/flow.html).
  * Para tratar operações assíncronas, o GetWeatherForecast utiliza as Kotlin Coroutines. As Coroutines são uma maneira eficiente e concisa de escrever código assíncrono em Kotlin, permitindo que tarefas demoradas sejam executadas sem bloquear a thread principal. Além disso, o aplicativo utiliza o Asynchronous Flow, que é uma extensão das Coroutines, para trabalhar com sequências de valores assíncronos de forma simples e elegante.
## Outros componentes do Android:
* [Jetpack Compose](https://developer.android.com/jetpack/compose).
  * O GetWeatherForecast também aproveita o Jetpack Compose, um moderno toolkit de interface do usuário para a criação de interfaces nativas do Android. Com o Jetpack Compose, é possível desenvolver interfaces de usuário dinâmicas e responsivas, proporcionando uma experiência visualmente atraente e interativa aos usuários.
## Outras Bibliotecas:
* [Retrofit](https://square.github.io/retrofit/).
  * O Retrofit é utilizado no GetWeatherForecast para facilitar a integração com a API OpenWeather. Essa biblioteca simplifica a comunicação de rede ao converter chamadas HTTP em objetos Kotlin de maneira fácil e declarativa, tornando o processo de obtenção dos dados meteorológicos da API mais eficiente e conveniente.
