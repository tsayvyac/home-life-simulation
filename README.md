# Smart home
## Prvotní dokumentace
### Diagramy
Prvotní Class a Use-Case diagramy najdete zde:
- [Class diagram](diagram/uml_v1.pdf)
- [UC diagram](diagram/uc_v1.pdf)

### Předpokládané design patterny (11):
- **Builder**. Používá se k postupnému vytváření domu a pokojů.
- **Singleton**. Pro vytváření objektů, které budou mít jen jednu instanci.
- **State**. Vytvoří nové třídy pro všechny možné stavy spotřebičů a lidí.
- **Null Object pattern**. Vyhnout se NPE v některých připadech.
- **Lazy Loading**. Používá se ke generování dokumentace jen v připadě, kdy se spotřebič rozbíje.
- **Factory Method**. Používá se při vytváření spotřebičů.
- **Composite**. Slouží k aktualizaci domu a jeho komponent (pátra, pokoje).
- **Visitor**. Umístí nové chování do samostatné třídy Visitor, místo integrování do stávajících tříd.
- **Observer**. Oznámí, pokud se rozbíje spotřebič nebo budou aktivovány senzory.
- **Strategy**. Používá se k výběru řešení události.
- **Template Method**. Definuje kostru aktivit, podtřídy přepisují jednotlivé kroky.