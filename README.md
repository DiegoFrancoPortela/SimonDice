# SimonDice

## Descripción

SimonDice es una pequeña aplicación que imita ligeramente el concepto del juego Simon Dice, pero con algunas modificaciones propias.
Esta app está desarrollada en Kotlin con Android Studio.

## Contenido

Esta App implementa diversas Corrutinas para su correcto funcionamiento, además de múltiples métodos, por ejemplo, para reproducir sonido, cambiar colores,etc...

![Imagen Corrutina](https://lh3.googleusercontent.com/fife/AAWUweWFepltAOZzvMmTpBng92GWWNC3xKJbzhTtDGS-krLeS8NYJvH1c8Ak-MqhO5MdrtrUNSCfNqyH1eJdkpA4jusI-W6eXlh67Qf4D1lOuUkTLdB6dft99TUbi7HPtBv3iyfbK4qEWYhLTPEfQZgeqpiqQ_CrASDmPkD4LlH7URceMQexiQDLpK9Y4BK5N-o7Z_wbAEf5R_H9WD3wqFgygr_8FVbkDLe7YwqSvE02tw1VmgXp95RXm2dT0Lk6N3WZYmiEmXhBXIEny0l-_8JiUerABPUyA2YSh4J73ni53RUZAV6MSAQ7k5lGOnzR5VmzKPzZoTe2epri5q2VKFaxFMMjk8D52_ur2ZnjiBiFCiKnbnwpUcpRE5n11Uvdel5zc8RPJmfiwzpkmYg-sYiuty6mUZ4yTqBbRJOYiTOXijpMVloPbsJPoNM4CRuBs4G2vDEMywR0Oyg5KbIS11uHCXGyfU_9MzXCgRVOnEc2AmUChQfQnAFXOUiwEpoDjaKU6lj6EbveI7zDp1LA2HRZQfjlX7l40GjKW5OpiIIEweShV0XaCJwLWaHWRvEyxColz76arLyQgWmdEi7QYlbQ6X-bkeWTcA-dMHnB-c09HIgmvlvC9WXFYb2h5xyfR-f7YddnlbAzlUVX7aGeJiTyDo3JpLd_tiTHKIgD3_ked43YbifmnChvJizILjYCFrK3LZCJMGSSsJJCXmrfoGXDxBa3V9mUYZ79On4=w1848-h637-ft)

## Funcionamiento

El funcionamiento de la App es un tanto distinto al Simon Dice convencional.

* El juego empieza mostrando una secuencia de **4 colores**.
* En todas las rondas cambiará este patrón.
* A partir de la ronda **5**, se activa un **evento especial**, que añadirá **1 color extra** al patrón.
* Por último, en la ronda **10** se repetirá el evento especial anterior, formando un patrón de colores de **6**.

- Finalmente, una vez pierdas, mostrará una pequeña animación y mostrará un mensaje.

## Esquema

Este es el esquema que sigue el programa para ejecutarse. El orden de las funciones y otros aspectos.

![Imagen Esquema](https://lh3.googleusercontent.com/fife/AAWUweXVcfTaxlQDyBQGggWGSrx97BGiPVQEjbWxAYb0nU-ayM-bNj0IoviR1HBHiFVHpk_ga3HRMSoYJUYOKLiBqNwgtdyFk4jI3XP6ol27iUaVXmUxF6bwOFcdfgkMhg6WehEBei-k1LvCSmkWws-WYPjIMii9Dc9RpdoJirfnKkYI6O4tggTSrzZ40vlxUlYlx3hCxKGUtJ888AGWhI8KpjtMSqT1ELy1rRuzD-xNOVNwOeShNk8tJdVgkBrziQW2IPNhdyGAO1UWQKF1cx-5jzT1oTG4YOrmTPA6s9xxEeZmEGxkKaNn2q8ptgvxdM39or_1fi9_lkSd2gKSFlN3xnn3befevuFJT-mW8zosiKZL9gsm2i7IJgPEiQ65tnraTIFdH56OHyl36juSaE5Y67axGNBul4JENq7A-D4cqS_ON0DKrYxugdhucAbONk-xhrvSgpJvXBxtSpVQttxq4cMYEXYO5f8vdd0ad8q4v2xZ5_3pCqI8ICcrTe1cDDLqItj9USXWaiHTbgnJBvkLCas_Dtn3B5fFy9RY6k_XSbIJrdxTVz1w3UlsxLGaR9blGgP0aW8LlWdTOpWjLvLyIZ2-46ttmgBKwT40nWnvIFt42qQpboL-RNNBI22W7thtY0QYUJ8ID9lh6F88ZG-ynW5tkVLYE-ptf6HIQTJ5QugtcgrAIvmDbf3XuxACi9DZSmQH0vZj5pe-eqPEvMSHP-wQ2JnGD-r38bk=w1920-h937-ft)

## Diseño

El programa intenta seguir este esquema de colores, que a su veces procura ser visualmente **atractivo** y con un toque **minimalista**.

![Imagen Paleta](https://lh3.googleusercontent.com/fife/AAWUweWShAdfCd4T97sUpb6seRojR3u9_s-rFuXfZ8aGd7ckckS5iX0megwa8YCDZ7N9yBK21kCWC6gjKgW7LOSei09dnb5EEVH9jsDpisatRw9bv-todO-hgSW1xpkUutS0653Scpdnwmm02-QsGkS4ssqAJkfNR6A0Dhhq6U-VhEYrv-DGC8H-_WDNLVex88ZnZBG3R7XVAcPFtaaIwBixfpd8SPfErVdNubrFgUgq9eC-fk1jjOAr6cuKH_SZPO1hpQ9FBeartXCDllnm1_d6iQO7S2VUzRffvMx1YTZqJPR0VcuEVOu5t3ZDbFrvyNkmQ7g7XxOCuNUUay3VmcLH7Wrm8B05abloPsMzla6-hQoS5NseQvw3iyoY65ErjSls8JOBY38Hil7gkoZICDvMV3bVkMduaJcFUV0wnQJQQPSEIXBQl52vKpAQn_CaB-8068Hc6fO6jSl_JURbSFrih3N8192tonutWuZXFKlmODeKRMALTj_-0pj2ELOvyW8c2At4IEI1l24oDYnEXDibQ6yrItsur3-AVHgybrwl3rMMFr53xsWDSzVw8jwrmBzw6IrALXoD42P1296cDyms_Z8taw8LPgfLJWt0jeRJ6fEzdThC-NBEsA6kT4Xy5mnIR-dGI9iZOJpbfdMRLWQLYcW2Bk1rbiguOUKHx0FN_dUqV1e_PMj7gTcsYRF8LkEgGVaSGU4jjHk6VIU60IxudOc1JiaOUEM8=w1920-h937-ft)

## Imágenes

![Imagen Icono](https://lh3.googleusercontent.com/fife/AAWUweVpxKEpJPAX9s0mgOmxNdq__FT6EiqQ6V7390pKgfhJimGS0r3c5p3x8STSwXG8Jcxhy_Iyls3oNEBpTqISqusIQHOtco-V3w_V5N_vgeiPkaJS2rxQ48sqQZsXGiLGBCVeqcV6aM4jHwXpSsQOQ2txgHgpMbaLf-0XJOanrmlSBSRxAx0D59G2TUeJG4SjZelOm2XWvRSaWjgSCKga225RoR5C9HVtD9uuTjHCLJnjV03rr_xRgR-AhdfpoWqP56mbQkD8BgemVK9H4m8_mHWAKO80WpY95OE6fB_AJmjIPjyITAO9-sOp8PWMqwkmFopjLO5GXPQyIgMEG0sARarzmXhlVACNPPf0I6ontKCSH5Efw3KqMvSwcPdta0JW3GnDYWry_NX5DLA92s1gKqjVeJZBR2dFP1Za_FAPsNmPGQxW1d94hV0-AkxS4bTyYp-YrrTKf6odpZsCFc5_plFfw873eFvS2CTDYe6w5D36K3rSa9DfrlBk9NhXiaoyyFaLMEue9TQHiLQvrfCSg6e12nMAkVTFf-FQOK-dT0qUL0McC36VxNh2kb7cgIFCzJrxviczpXrPv7Io3wSnAexqb6vJlslFOuedrAuElOiXPdNmDiu1tupOvXBZIt1FSjYGh3kdu1riT2h_3YVK0FUsL92lZMU9X1T8v0LH6TkLRZv2416mDHYqFBcV37HxP8FUvNWmSrSPnmqrsVXaN4NydliM91f1ZAQ=w1920-h880-ft)

**Video:**

[![Video](https://lh3.googleusercontent.com/fife/AAWUweXe8REpr4ZxXxSnn7SsfjU6KC9huuMsmrd62j9Ezmtwf8WcSPps6b-erikNT8Uloh_vs6b-3RLLTFVtP4sdsmEWy_ZaAkgo6OaRKY0YMbhVby6V-CpgeYukNeKaXpcg02l7KWyqIBefcYYkX9izvCItLm23SCMenj3fPXrw3IGcFKR8v0knN_T9vTYrilNoNHGuUZiT-xR2EHzHqVYxwsXFKiOrjLOEgRX0N9NwdjO-mK52wZFv2vEkUr6ULSHQbW-OORwb5cTOpfvZZpPeCgKfcbIf-PtgDtDt_4gECduNKx6V9VRmv7TsvTJIpaGpJU0vH2UnnIipHheaFbveJeP-Md2pbzFznbQuQ5qYYANOLmtsDA008vBtAntUkS14cKk0dfpKe43sLNcRoavTdmCOG08i_xdjAW38e5P8JynNbmgAw4T5WX369LomgL6jsCRT4dOCZhuvywlSRyzciCCcS2WlzA0go5U-B8TNRPWBgspTmX2PQKuobCy4c9ycEuVdsrLNqDGOCFQtikC4N0QuXZfuLYPx1YJD6eMh4hv-rUkQpJRqVQ8Ycqyvo1BttlJGotHwqsXG2brqFWuKn6GWFkeoM8DCZi4p2iKZnD00nUe31UScpyIpQ2x3KW4yWoCHT6o-K_LCBz3ULTPReBfAADYJOGOXnEQNtGLwhz2monJU88vgL6JO7EpSaWbKNW-vFJqHQklTCIU__psdsYkscKdhaEiSqvo=w1920-h937-ft)](https://youtu.be/fdpDmU-6lDY)

