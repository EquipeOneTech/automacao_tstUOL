#language: pt
Funcionalidade: Validar tela instrução

    Contexto:
        Dado que estou no site uol "https://www.uol.com.br/"
        #E estou na pagina tela inicial
        Quando eu colocar o mouse sobre o menu "//*[@id='menuHorizontal']/ul/li[2]/a/span"
        E clicar com o mouse sobre o link "//*[@id='menuHorizontal']/ul/li[2]/div/div/div/ul/li[2]/a"
        Então deve ser exibida tela com o texto "TODAS AS SALAS" no campo "/html/body/div[4]/header/h1"  #xpath

    Cenário: acessar sala de bate-papo
        #Dado estou na pagina com todas salas de bate-papo
        Quando eu clicar no menu "/html/body/div[3]/section/button"  #xpath
        E clicar com o mouse sobre o link "/html/body/div[3]/section/nav/div/ul/li[1]/a/span"  #xpath
        E eu clicar no item "/html/body/div[3]/section/nav/div[2]/ul/li[1]/a/span" #xpath
        E eu clicar no item "/html/body/div[3]/section/nav/div[3]/ul/li[1]/a/span[1]" #xpath
        E eu clicar no item "/html/body/div[3]/section/nav/div[3]/ul/li[1]/ul/li[1]/a/span[1]/span" #xpath
        Então deve ser exibida a tela com texto "Amizade-virtual-(1)" no campo "//*[@id='bp-header']/nav/div/div[1]/a/span[2]"

