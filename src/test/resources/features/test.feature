#language: ru
@Test
  Функционал: Проверка авторизации, создания новой задачи и сравнение счетчика
    @success
    Сценарий: Авторизация на сайте
      Дано Пользователь открыт страницу авторизации на eduJira
      Когда Пользователь ввел логин и пароль
      И Нажмет на кнопку Войти
      Тогда Он увидит заголовой System Dashboard

    Сценарий: ыва
      Дано