package br.com.mentoria.common;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Hamcrest {

    @Test
    void assertionsHamcrest() {
        // is() -> representa igualdade.
        assertThat("Gilson", is("Gilson"));
        assertThat("27", is("27"));

        // isA(String) -> valida se pertence ao tipo de dado
        assertThat(27, isA(Integer.class));

        // lessThan (valor) -> verifica se o valor atual é menor que o esperado
        assertThat(23, lessThan(25));

        // greaterThan (valor) -> verifica se o valor atual é maior do que o esperado
        assertThat(27, greaterThan(25));

        // Trabalhando com lista
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // hasSize (tamanho) -> valida o tamanho da lista
        assertThat(numeros, hasSize(10));

        // contains(lista) -> valida se a lista está como esperado
        assertThat(numeros, contains(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        // containsInAnyOrder(lista) -> valida se os valores existem na lista, sem se preocupar com a posição
        assertThat(numeros, containsInAnyOrder(1, 5, 4, 6, 2, 7, 3, 9, 8, 10));

        // hasItem(item) -> Valida se o item existe na lista
        assertThat(numeros, hasItem(5));

        // Outras validações importantes

        // is(not(valor)) ou not(valor) -> valida se o resultado atual não é igual ao esperado
        assertThat("ETech", not("E.tech"));

        // anyOf(Matchers) -> valida se o valor atual é igual a um ou outros valores.
        assertThat("Gilson Rodrigues", anyOf(is("Gilson Rodrigues"), is("Gilson")));

        // allOf(Matchers)
        // startsWith(valor) -> valida se o valor atual inicia com o valor esperado
        // containsString(valor) -> valida se existe o item esperado em qualquer posição
        // endsWithIgnoringCase -> valida se atual finaliza com o valor esperado, ignorando o Caps Lock
        assertThat("Gilson Rodrigues", allOf(
                startsWith("Gilson"),
                startsWithIgnoringCase("Gilson"),
                containsString("Gilson"),
                endsWithIgnoringCase("Rodrigues") // Corrigido para evitar erro
        ));
    }
}
