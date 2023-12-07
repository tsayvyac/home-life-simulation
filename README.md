# Smart home simulation

## UML diagram:
- [UML diagram](diagram/uml_final.pdf)
- [Prvotní UML diagram](diagram/uml_v1.pdf)
- [Prvotní UC diagram](diagram/uc_v1.pdf)

## Použité design patterny (9):
- **Builder**. Používá se k postupnému vytváření domu, páter a pokojů. V package: `/smarthome/home`, `/smarthome/room`.
- **Singleton**. Pro vytváření objektů, které budou mít jen jednu instanci. Používá se dva typy singletonu LAZY a EAGER. V package: `/smarthome`, `/appliance/factory`.
- **State**. Vytvoří nové třídy pro všechny možné stavy spotřebičů. V package: `/appliance/state`.
- **Lazy Loading**. Používá se ke generování dokumentace jen v připadě, kdy se spotřebič rozbíje. Ve třidě: `/appliance/HomeAppliance`.
- **Factory Method**. Používá se při vytváření spotřebičů. V package: `/appliance/factory`.
- **Composite**. Slouží k aktualizaci domu a jeho komponent (pátra, pokoje, executorů, spotřebičů). V package: `/component`.
- **Visitor**. Umístí nové chování do samostatné třídy Visitor, místo integrování do stávajících tříd. Používá se pro generování Home Configuration Report a Consumption Report. V package: `/report`.
- **Observer**. Oznámí, pokud se rozbíje spotřebič nebo budou aktivovány senzory. V package: `/appliance/observer`.
- **Template Method**. Definuje kostru aktivit, podtřídy přepisují krok `solve()`. V package: `/entity/activity`.

## Požadavky:

### Funkční:
- [x] Entity se kterými pracujeme je dům, okno (+ venkovní žaluzie), patro v domu, senzor, zařízení (=spotřebič), osoba, auto, kolo, domácí zvíře jiného než hospodářského typu, plus libovolné další entity.
- [x] Jednotlivá zařízení v domu mají API na ovládání. Zařízení mají stav, který lze měnit pomocí API na jeho ovládání. Akce z API jsou použitelné podle stavu zařízení. Vybraná zařízení mohou mít i obsah - lednice má jídlo, CD přehrávač má CD.
- [x] Spotřebiče mají svojí spotřebu v aktivním stavu, idle stavu, vypnutém stavu.
- [x] Jednotlivá zařízení mají API na sběr dat o tomto zařízení. O zařízeních sbíráme data jako spotřeba elektřiny, plynu, vody a funkčnost (klesá lineárně s časem).
- [x] Jednotlivé osoby a zvířata mohou provádět aktivity(akce), které mají nějaký efekt na zařízení nebo jinou osobu. Např. Plynovy_kotel_1[oteverny_plyn] + Otec.zavritPlyn(plynovy_kotel_1) -> Plynovy_kotel_1[zavreny_plyn].
- [x] Jednotlivá zařízení a osoby se v každém okamžiku vyskytují v jedné místnosti (pokud nesportují) a náhodně generují eventy (eventem může být důležitá informace a nebo alert).
- [x]  Eventy jsou přebírány a odbavovány vhodnou osobou (osobami) nebo zařízením (zařízeními). Např.:
    - čidlo na vítr (vítr) => vytažení venkovních žaluzií 
    - jistič (výpadek elektřiny) => vypnutí všech nedůležitých spotřebičů (v provozu zůstávají pouze ty nutné)
    - čidlo na vlhkost (prasklá trubka na vodu) => máma -> zavolání hasičů, táta -> uzavření vody;dcera -> vylovení křečka 
    - Miminko potřebuje přebalit => táta se skrývá, máma -> přebalení 
    - Zařízení přestalo fungovat => ...
    - V lednici došlo jídlo => ...
- [x] Vygenerování reportů:
  - HouseConfigurationReport: veškerá konfigurační data domu zachovávající hieararchii - dům -> patro -> místnost -> okno -> žaluzie atd. Plus jací jsou obyvatelé domu. 
  - EventReport: report eventů, kde grupujeme eventy podle typu, zdroje eventů a jejich cíle (jaká entita event odbavila)
  - ActivityAndUsageReport: Report akcí (aktivit) jednotlivých osob a zvířat, kolikrát které osoby použily které zařízení. 
  - ConsumptionReport: Kolik jednotlivé spotřebiče spotřebovaly elektřiny, plynu, vody. Včetně finančního vyčíslení.
- [x] Při rozbití zařízení musí obyvatel domu prozkoumat dokumentaci k zařízení - najít záruční list, projít manuál na opravu a provést nápravnou akcí (např. Oprava svépomocí, koupě nového atd.). Manuály zabírají mnoho místa a trvá dlouho než je najdete. Hint: Modelujte jako jednoduché akce ...dokumentace je přístupná jako proměnná přímo v zařízení, nicméně se dotahuje až, když je potřeba.
- [x] Rodina je aktivní a volný čas tráví zhruba v poměru (50% používání spotřebičů v domě a 50% sport kdy používá sportovní náčiní kolo nebo lyže). Když není volné zařízení nebo sportovní náčiní, tak osoba čeká.

### Nefunkční:
- [x] Není požadována autentizace ani autorizace.
- [x] Aplikace může běžet pouze v jedné JVM.
- [x] Aplikaci pište tak, aby byly dobře schované metody a proměnné, které nemají být dostupné ostatním třídám. Vygenerovný javadoc by měl mít co nejméně public metod a proměnných.
- [x] Reporty jsou generovány do textového souboru.
- [x] Konfigurace domu, zařízení a obyvatel domu může být nahrávána přímo z třídy nebo externího souboru (preferován je json).

### Výstupy:
- [x] Design ve formě use case diagramů, class diagramů a stručného popisu jak chcete úlohu realizovat.
- [x] Veřejné API - Javadoc vygenerovaný pro funkce, kterými uživatel pracuje s vaším software.
- [x] Dvě různé konfigurace domu a pro ně vygenerovány reporty za různá období. Minimální konfigurace alespoň jednoho domu je: 6 osob, 3 zvířata, 8 typů spotřebičů, 20 ks spotřebičů, 6 místností, jedny lyže, dvě kola. 