package tacos.web.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tacos.Taco;
import tacos.data.TacoRepository;

@RestController
@RequestMapping(path="/design", produces="application/json")
@CrossOrigin(origins="*")
public class DesignTacoController {
    private TacoRepository tacoRepo;

    public DesignTacoController(TacoRepository tacoRepo) {
        this.tacoRepo = tacoRepo;
    }

    @GetMapping("/recent")
    public Flux<Taco> recentTacos() {
        return tacoRepo.findAll().take(12);
    }
//    @GetMapping("/recent")
//    public Flux<Taco> recentTacos() {
//        return Flux.fromIterable(tacoRepo.findAll()).take(12);
//    }
//    @GetMapping("/recent")
//    public Iterable<Taco> recentTacos() {
//        PageRequest page = PageRequest.of(
//                0, 12, Sort.by("createdAt").descending());
//        return tacoRepo.findAll(page).getContent();
//    }

//    @GetMapping("/recenth")
//    public CollectionModel<EntityModel<Taco>> recenthTacos() {
//        PageRequest page = PageRequest.of(
//                0, 12, Sort.by("createdAt").descending());
//        List<Taco> tacos = tacoRepo.findAll(page).getContent();
//
//        CollectionModel<EntityModel<Taco>> recentCollectionModel = CollectionModel.wrap(tacos);
//        recentCollectionModel.add(
//                linkTo(methodOn(DesignTacoController.class).recenthTacos())
//                        .withSelfRel()
//        );
//        return recentCollectionModel;
//    }

    @GetMapping("/{id}")
    public Mono<Taco> tacoById(@PathVariable("id") String id) {
        return tacoRepo.findById(id);
    }
//    @GetMapping("/{id}")
//    public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id) {
//        Optional<Taco> optTaco = tacoRepo.findById(id);
//        if (optTaco.isPresent()) {
//          return new ResponseEntity<>(optTaco.get(), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Taco> postTaco(@RequestBody Taco taco) {
        return tacoRepo.save(taco);
    }
//    @PostMapping(consumes = "application/json")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Mono<Taco> postTaco(@RequestBody Mono<Taco> tacoMono) {
//        return tacoRepo.saveAll(tacoMono).next();
//    }
//    @PostMapping(consumes="application/json")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Taco postTaco(@RequestBody Taco taco) {
//        return tacoRepo.save(taco);
//    }
}