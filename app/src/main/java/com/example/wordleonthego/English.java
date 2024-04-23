package com.example.wordleonthego;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class English extends AppCompatActivity {
    /*╗       ██╗ █████╗ ██████╗ ██████╗   ██╗     ██╗ ██████╗████████╗
    ██║  ██╗  ██║██╔══██╗██╔══██╗██╔══██╗  ██║     ██║██╔════╝╚══██╔══╝
    ╚██╗████╗██╔╝██║  ██║██████╔╝██║  ██║  ██║     ██║╚█████╗    ██║
     ████╔═████║ ██║  ██║██╔══██╗██║  ██║  ██║     ██║ ╚═══██╗   ██║
     ╚██╔╝ ╚██╔╝ ╚█████╔╝██║  ██║██████╔╝  ███████╗██║██████╔╝   ██║
      ╚═╝   ╚═╝   ╚════╝ ╚═╝  ╚═╝╚═════╝   ╚══════╝╚═╝╚═════╝    ╚*/

    public static String[] wordList = {"aback", "abase", "abate", "abbey", "abbot", "abhor", "abide", "abled", "abode", "abort", "about", "above", "abuse", "abyss", "acorn", "acrid", "actor", "acute", "adage", "adapt", "adept", "admin", "admit", "adobe", "adopt", "adore", "adorn", "adult", "affix", "afire", "afoot", "afoul", "after", "again", "agape", "agate", "agent", "agile", "aging", "aglow", "agony", "agora", "agree", "ahead", "aider", "aisle", "alarm", "album", "alert", "algae", "alibi", "alien", "align", "alike", "alive", "allay", "alley", "allot", "allow", "alloy", "aloft", "alone", "along", "aloof", "aloud", "alpha", "altar", "alter", "amass", "amaze", "amber", "amble", "amend", "amiss", "amity", "among", "ample", "amply", "amuse", "angel", "anger", "angle", "angry", "angst", "anime", "ankle", "annex", "annoy", "annul", "anode", "antic", "anvil", "aorta", "apart", "aphid", "aping", "apnea", "apple", "apply", "apron", "aptly", "arbor", "ardor", "arena", "argue", "arise", "armor", "aroma", "arose", "array", "arrow", "arson", "artsy", "ascot", "ashen", "aside", "askew", "assay", "asset", "atoll", "atone", "attic", "audio", "audit", "augur", "aunty", "avail", "avert", "avian", "avoid", "await", "awake", "award", "aware", "awash", "awful", "awoke", "axial", "axiom", "axion", "azure", "bacon", "badge", "badly", "bagel", "baggy", "baker", "baler", "balmy", "banal", "banjo", "barge", "baron", "basal", "basic", "basil", "basin", "basis", "baste", "batch", "bathe", "baton", "batty", "bawdy", "bayou", "beach", "beady", "beard", "beast", "beech", "beefy", "befit", "began", "begat", "beget", "begin", "begun", "being", "belch", "belie", "belle", "belly", "below", "bench", "beret", "berry", "berth", "beset", "betel", "bevel", "bezel", "bible", "bicep", "biddy", "bigot", "bilge", "billy", "binge", "bingo", "biome", "birch", "birth", "bison", "bitty", "black", "blade", "blame", "bland", "blank", "blare", "blast", "blaze", "bleak", "bleat", "bleed", "bleep", "blend", "bless", "blimp", "blind", "blink", "bliss", "blitz", "bloat", "block", "bloke", "blond", "blood", "bloom", "blown", "bluer", "bluff", "blunt", "blurb", "blurt", "blush", "board", "boast", "bobby", "boney", "bongo", "bonus", "booby", "boost", "booth", "booty", "booze", "boozy", "borax", "borne", "bosom", "bossy", "botch", "bough", "boule", "bound", "bowel", "boxer", "brace", "braid", "brain", "brake", "brand", "brash", "brass", "brave", "bravo", "brawl", "brawn", "bread", "break", "breed", "briar", "bribe", "brick", "bride", "brief", "brine", "bring", "brink", "briny", "brisk", "broad", "broil", "broke", "brood", "brook", "broom", "broth", "brown", "brunt", "brush", "brute", "buddy", "budge", "buggy", "bugle", "build", "built", "bulge", "bulky", "bully", "bunch", "bunny", "burly", "burnt", "burst", "bused", "bushy", "butch", "butte", "buxom", "buyer", "bylaw", "cabal", "cabby", "cabin", "cable", "cacao", "cache", "cacti", "caddy", "cadet", "cagey", "cairn", "camel", "cameo", "canal", "candy", "canny", "canoe", "canon", "caper", "caput", "carat", "cargo", "carol", "carry", "carve", "caste", "catch", "cater", "catty", "caulk", "cause", "cavil", "cease", "cedar", "cello", "chafe", "chaff", "chain", "chair", "chalk", "champ", "chant", "chaos", "chard", "charm", "chart", "chase", "chasm", "cheap", "cheat", "check", "cheek", "cheer", "chess", "chest", "chick", "chide", "chief", "child", "chili", "chill", "chime", "china", "chirp", "chock", "choir", "choke", "chord", "chore", "chose", "chuck", "chump", "chunk", "churn", "chute", "cider", "cigar", "cinch", "circa", "civic", "civil", "clack", "claim", "clamp", "clang", "clank", "clash", "clasp", "class", "clean", "clear", "cleat", "cleft", "clerk", "click", "cliff", "climb", "cling", "clink", "cloak", "clock", "clone", "close", "cloth", "cloud", "clout", "clove", "clown", "cluck", "clued", "clump", "clung", "coach", "coast", "cobra", "cocoa", "colon", "color", "comet", "comfy", "comic", "comma", "conch", "condo", "conic", "copse", "coral", "corer", "corny", "couch", "cough", "could", "count", "coupe", "court", "coven", "cover", "covet", "covey", "cower", "coyly", "crack", "craft", "cramp", "crane", "crank", "crash", "crass", "crate", "crave", "crawl", "craze", "crazy", "creak", "cream", "credo", "creed", "creek", "creep", "creme", "crepe", "crept", "cress", "crest", "crick", "cried", "crier", "crime", "crimp", "crisp", "croak", "crock", "crone", "crony", "crook", "cross", "croup", "crowd", "crown", "crude", "cruel", "crumb", "crump", "crush", "crust", "crypt", "cubic", "cumin", "curio", "curly", "curry", "curse", "curve", "curvy", "cutie", "cyber", "cycle", "cynic", "daddy", "daily", "dairy", "daisy", "dally", "dance", "dandy", "datum", "daunt", "dealt", "death", "debar", "debit", "debug", "debut", "decal", "decay", "decor", "decoy", "decry", "defer", "deign", "deity", "delay", "delta", "delve", "demon", "demur", "denim", "dense", "depot", "depth", "derby", "deter", "detox", "deuce", "devil", "diary", "dicey", "digit", "dilly", "dimly", "diner", "dingo", "dingy", "diode", "dirge", "dirty", "disco", "ditch", "ditto", "ditty", "diver", "dizzy", "dodge", "dodgy", "dogma", "doing", "dolly", "donor", "donut", "dopey", "doubt", "dough", "dowdy", "dowel", "downy", "dowry", "dozen", "draft", "drain", "drake", "drama", "drank", "drape", "drawl", "drawn", "dread", "dream", "dress", "dried", "drier", "drift", "drill", "drink", "drive", "droit", "droll", "drone", "drool", "droop", "dross", "drove", "drown", "druid", "drunk", "dryer", "dryly", "duchy", "dully", "dummy", "dumpy", "dunce", "dusky", "dusty", "dutch", "duvet", "dwarf", "dwell", "dwelt", "dying", "eager", "eagle", "early", "earth", "easel", "eaten", "eater", "ebony", "eclat", "edict", "edify", "eerie", "egret", "eight", "eject", "eking", "elate", "elbow", "elder", "elect", "elegy", "elfin", "elide", "elite", "elope", "elude", "email", "embed", "ember", "emcee", "empty", "enact", "endow", "enema", "enemy", "enjoy", "ennui", "ensue", "enter", "entry", "envoy", "epoch", "epoxy", "equal", "equip", "erase", "erect", "erode", "error", "erupt", "essay", "ester", "ether", "ethic", "ethos", "etude", "evade", "event", "every", "evict", "evoke", "exact", "exalt", "excel", "exert", "exile", "exist", "expel", "extol", "extra", "exult", "eying", "fable", "facet", "faint", "fairy", "faith", "false", "fancy", "fanny", "farce", "fatal", "fatty", "fault", "fauna", "favor", "feast", "fecal", "feign", "fella", "felon", "femme", "femur", "fence", "feral", "ferry", "fetal", "fetch", "fetid", "fetus", "fever", "fewer", "fiber", "fibre", "ficus", "field", "fiend", "fiery", "fifth", "fifty", "fight", "filer", "filet", "filly", "filmy", "filth", "final", "finch", "finer", "first", "fishy", "fixer", "fizzy", "fjord", "flack", "flail", "flair", "flake", "flaky", "flame", "flank", "flare", "flash", "flask", "fleck", "fleet", "flesh", "flick", "flier", "fling", "flint", "flirt", "float", "flock", "flood", "floor", "flora", "floss", "flour", "flout", "flown", "fluff", "fluid", "fluke", "flume", "flung", "flunk", "flush", "flute", "flyer", "foamy", "focal", "focus", "foggy", "foist", "folio", "folly", "foray", "force", "forge", "forgo", "forte", "forth", "forty", "forum", "found", "foyer", "frail", "frame", "frank", "fraud", "freak", "freed", "freer", "fresh", "friar", "fried", "frill", "frisk", "fritz", "frock", "frond", "front", "frost", "froth", "frown", "froze", "fruit", "fudge", "fugue", "fully", "fungi", "funky", "funny", "furor", "furry", "fussy", "fuzzy", "gaffe", "gaily", "gamer", "gamma", "gamut", "gassy", "gaudy", "gauge", "gaunt", "gauze", "gavel", "gawky", "gayer", "gayly", "gazer", "gecko", "geeky", "geese", "genie", "genre", "ghost", "ghoul", "giant", "giddy", "gipsy", "girly", "girth", "given", "giver", "glade", "gland", "glare", "glass", "glaze", "gleam", "glean", "glide", "glint", "gloat", "globe", "gloom", "glory", "gloss", "glove", "glyph", "gnash", "gnome", "godly", "going", "golem", "golly", "gonad", "goner", "goody", "gooey", "goofy", "goose", "gorge", "gouge", "gourd", "grace", "grade", "graft", "grail", "grain", "grand", "grant", "grape", "graph", "grasp", "grass", "grate", "grave", "gravy", "graze", "great", "greed", "green", "greet", "grief", "grill", "grime", "grimy", "grind", "gripe", "groan", "groin", "groom", "grope", "gross", "group", "grout", "grove", "growl", "grown", "gruel", "gruff", "grunt", "guard", "guava", "guess", "guest", "guide", "guild", "guile", "guilt", "guise", "gulch", "gully", "gumbo", "gummy", "guppy", "gusto", "gusty", "gypsy", "habit", "hairy", "halve", "handy", "happy", "hardy", "harem", "harpy", "harry", "harsh", "haste", "hasty", "hatch", "hater", "haunt", "haute", "haven", "havoc", "hazel", "heady", "heard", "heart", "heath", "heave", "heavy", "hedge", "hefty", "heist", "helix", "hello", "hence", "heron", "hilly", "hinge", "hippo", "hippy", "hitch", "hoard", "hobby", "hoist", "holly", "homer", "honey", "honor", "horde", "horny", "horse", "hotel", "hotly", "hound", "house", "hovel", "hover", "howdy", "human", "humid", "humor", "humph", "humus", "hunch", "hunky", "hurry", "husky", "hussy", "hutch", "hydro", "hyena", "hymen", "hyper", "icily", "icing", "ideal", "idiom", "idiot", "idler", "idyll", "igloo", "iliac", "image", "imbue", "impel", "imply", "inane", "inbox", "incur", "index", "inept", "inert", "infer", "ingot", "inlay", "inlet", "inner", "input", "inter", "intro", "ionic", "irate", "irony", "islet", "issue", "itchy", "ivory", "jaunt", "jazzy", "jelly", "jerky", "jetty", "jewel", "jiffy", "joint", "joist", "joker", "jolly", "joust", "judge", "juice", "juicy", "jumbo", "jumpy", "junta", "junto", "juror", "kappa", "karma", "kayak", "kebab", "khaki", "kinky", "kiosk", "kitty", "knack", "knave", "knead", "kneed", "kneel", "knelt", "knife", "knock", "knoll", "known", "koala", "krill", "label", "labor", "laden", "ladle", "lager", "lance", "lanky", "lapel", "lapse", "large", "larva", "lasso", "latch", "later", "lathe", "latte", "laugh", "layer", "leach", "leafy", "leaky", "leant", "leapt", "learn", "lease", "leash", "least", "leave", "ledge", "leech", "leery", "lefty", "legal", "leggy", "lemon", "lemur", "leper", "level", "lever", "libel", "liege", "light", "liken", "lilac", "limbo", "limit", "linen", "liner", "lingo", "lipid", "lithe", "liver", "livid", "llama", "loamy", "loath", "lobby", "local", "locus", "lodge", "lofty", "logic", "login", "loopy", "loose", "lorry", "loser", "louse", "lousy", "lover", "lower", "lowly", "loyal", "lucid", "lucky", "lumen", "lumpy", "lunar", "lunch", "lunge", "lupus", "lurch", "lurid", "lusty", "lying", "lymph", "lynch", "lyric", "macaw", "macho", "macro", "madam", "madly", "mafia", "magic", "magma", "maize", "major", "maker", "mambo", "mamma", "mammy", "manga", "mange", "mango", "mangy", "mania", "manic", "manly", "manor", "maple", "march", "marry", "marsh", "mason", "masse", "match", "matey", "mauve", "maxim", "maybe", "mayor", "mealy", "meant", "meaty", "mecca", "medal", "media", "medic", "melee", "melon", "mercy", "merge", "merit", "merry", "metal", "meter", "metro", "micro", "midge", "midst", "might", "milky", "mimic", "mince", "miner", "minim", "minor", "minty", "minus", "mirth", "miser", "missy", "mocha", "modal", "model", "modem", "mogul", "moist", "molar", "moldy", "money", "month", "moody", "moose", "moral", "moron", "morph", "mossy", "motel", "motif", "motor", "motto", "moult", "mound", "mount", "mourn", "mouse", "mouth", "mover", "movie", "mower", "mucky", "mucus", "muddy", "mulch", "mummy", "munch", "mural", "murky", "mushy", "music", "musky", "musty", "myrrh", "nadir", "naive", "nanny", "nasal", "nasty", "natal", "naval", "navel", "needy", "neigh", "nerdy", "nerve", "never", "newer", "newly", "nicer", "niche", "niece", "night", "nigga", "ninja", "ninny", "ninth", "noble", "nobly", "noise", "noisy", "nomad", "noose", "north", "nosey", "notch", "novel", "nudge", "nurse", "nutty", "nylon", "nymph", "oaken", "obese", "occur", "ocean", "octal", "octet", "odder", "oddly", "offal", "offer", "often", "olden", "older", "olive", "ombre", "omega", "onion", "onset", "opera", "opine", "opium", "optic", "orbit", "order", "organ", "other", "otter", "ought", "ounce", "outdo", "outer", "outgo", "ovary", "ovate", "overt", "ovine", "ovoid", "owing", "owner", "oxide", "ozone", "paddy", "pagan", "paint", "paler", "palsy", "panel", "panic", "pansy", "papal", "paper", "parer", "parka", "parry", "parse", "party", "pasta", "paste", "pasty", "patch", "patio", "patsy", "patty", "pause", "payee", "payer", "peace", "peach", "pearl", "pecan", "pedal", "penal", "pence", "penne", "penny", "perch", "peril", "perky", "pesky", "pesto", "petal", "petty", "phase", "phone", "phony", "photo", "piano", "picky", "piece", "piety", "piggy", "pilot", "pinch", "piney", "pinky", "pinto", "piper", "pique", "pitch", "pithy", "pivot", "pixel", "pixie", "pizza", "place", "plaid", "plain", "plait", "plane", "plank", "plant", "plate", "plaza", "plead", "pleat", "plied", "plier", "pluck", "plumb", "plume", "plump", "plunk", "plush", "poesy", "point", "poise", "poker", "polar", "polka", "polyp", "pooch", "poppy", "porch", "poser", "posit", "posse", "pouch", "pound", "pouty", "power", "prank", "prawn", "preen", "press", "price", "prick", "pride", "pried", "prime", "primo", "print", "prior", "prism", "privy", "prize", "probe", "prone", "prong", "proof", "prose", "proud", "prove", "prowl", "proxy", "prude", "prune", "psalm", "pubic", "pudgy", "puffy", "pulpy", "pulse", "punch", "pupal", "pupil", "puppy", "puree", "purer", "purge", "purse", "pushy", "putty", "pygmy", "quack", "quail", "quake", "qualm", "quark", "quart", "quash", "quasi", "queen", "queer", "quell", "query", "quest", "queue", "quick", "quiet", "quill", "quilt", "quirk", "quite", "quota", "quote", "quoth", "rabbi", "rabid", "racer", "radar", "radii", "radio", "rainy", "raise", "rajah", "rally", "ralph", "ramen", "ranch", "randy", "range", "rapid", "rarer", "raspy", "ratio", "ratty", "raven", "rayon", "razor", "reach", "react", "ready", "realm", "rearm", "rebar", "rebel", "rebus", "rebut", "recap", "recur", "recut", "reedy", "refer", "refit", "regal", "rehab", "reign", "relax", "relay", "relic", "remit", "renal", "renew", "repay", "repel", "reply", "rerun", "reset", "resin", "retch", "retro", "retry", "reuse", "revel", "revue", "rhino", "rhyme", "rider", "ridge", "rifle", "right", "rigid", "rigor", "rinse", "ripen", "riper", "risen", "riser", "risky", "rival", "river", "rivet", "roach", "roast", "robin", "robot", "rocky", "rodeo", "roger", "rogue", "roomy", "roost", "rotor", "rouge", "rough", "round", "rouse", "route", "rover", "rowdy", "rower", "royal", "ruddy", "ruder", "rugby", "ruler", "rumba", "rumor", "rupee", "rural", "rusty", "sadly", "safer", "saint", "salad", "sally", "salon", "salsa", "salty", "salve", "salvo", "sandy", "saner", "sappy", "sassy", "satin", "satyr", "sauce", "saucy", "sauna", "saute", "savor", "savoy", "savvy", "scald", "scale", "scalp", "scaly", "scamp", "scant", "scare", "scarf", "scary", "scene", "scent", "scion", "scoff", "scold", "scone", "scoop", "scope", "score", "scorn", "scour", "scout", "scowl", "scram", "scrap", "scree", "screw", "scrub", "scrum", "scuba", "sedan", "seedy", "segue", "seize", "semen", "sense", "sepia", "serif", "serum", "serve", "setup", "seven", "sever", "sewer", "shack", "shade", "shady", "shaft", "shake", "shaky", "shale", "shall", "shalt", "shame", "shank", "shape", "shard", "share", "shark", "sharp", "shave", "shawl", "shear", "sheen", "sheep", "sheer", "sheet", "sheik", "shelf", "shell", "shied", "shift", "shine", "shiny", "shire", "shirk", "shirt", "shoal", "shock", "shone", "shook", "shoot", "shore", "shorn", "short", "shout", "shove", "shown", "showy", "shrew", "shrub", "shrug", "shuck", "shunt", "shush", "shyly", "siege", "sieve", "sight", "sigma", "silky", "silly", "since", "sinew", "singe", "siren", "sissy", "sixth", "sixty", "skate", "skier", "skiff", "skill", "skimp", "skirt", "skulk", "skull", "skunk", "slack", "slain", "slang", "slant", "slash", "slate", "slave", "sleek", "sleep", "sleet", "slept", "slice", "slick", "slide", "slime", "slimy", "sling", "slink", "sloop", "slope", "slosh", "sloth", "slump", "slung", "slunk", "slurp", "slush", "slyly", "smack", "small", "smart", "smash", "smear", "smell", "smelt", "smile", "smirk", "smite", "smith", "smock", "smoke", "smoky", "smote", "snack", "snail", "snake", "snaky", "snare", "snarl", "sneak", "sneer", "snide", "sniff", "snipe", "snoop", "snore", "snort", "snout", "snowy", "snuck", "snuff", "soapy", "sober", "soggy", "solar", "solid", "solve", "sonar", "sonic", "sooth", "sooty", "sorry", "sound", "south", "sower", "space", "spade", "spank", "spare", "spark", "spasm", "spawn", "speak", "spear", "speck", "speed", "spell", "spelt", "spend", "spent", "sperm", "spice", "spicy", "spied", "spiel", "spike", "spiky", "spill", "spilt", "spine", "spiny", "spire", "spite", "splat", "split", "spoil", "spoke", "spoof", "spook", "spool", "spoon", "spore", "sport", "spout", "spray", "spree", "sprig", "spunk", "spurn", "spurt", "squad", "squat", "squib", "stack", "staff", "stage", "staid", "stain", "stair", "stake", "stale", "stalk", "stall", "stamp", "stand", "stank", "stare", "stark", "start", "stash", "state", "stave", "stead", "steak", "steal", "steam", "steed", "steel", "steep", "steer", "stein", "stern", "stick", "stiff", "still", "stilt", "sting", "stink", "stint", "stock", "stoic", "stoke", "stole", "stomp", "stone", "stony", "stood", "stool", "stoop", "store", "stork", "storm", "story", "stout", "stove", "strap", "straw", "stray", "strip", "strut", "stuck", "study", "stuff", "stump", "stung", "stunk", "stunt", "style", "suave", "sugar", "suing", "suite", "sulky", "sully", "sumac", "sunny", "super", "surer", "surge", "surly", "sushi", "swami", "swamp", "swarm", "swash", "swath", "swear", "sweat", "sweep", "sweet", "swell", "swept", "swift", "swill", "swine", "swing", "swirl", "swish", "swoon", "swoop", "sword", "swore", "sworn", "swung", "synod", "syrup", "tabby", "table", "taboo", "tacit", "tacky", "taffy", "taint", "taken", "taker", "tally", "talon", "tamer", "tango", "tangy", "taper", "tapir", "tardy", "tarot", "taste", "tasty", "tatty", "taunt", "tawny", "teach", "teary", "tease", "teddy", "teeth", "tempo", "tenet", "tenor", "tense", "tenth", "tepee", "tepid", "terra", "terse", "testy", "thank", "theft", "their", "theme", "there", "these", "theta", "thick", "thief", "thigh", "thing", "think", "third", "thong", "thorn", "those", "three", "threw", "throb", "throw", "thrum", "thumb", "thump", "thyme", "tiara", "tibia", "tidal", "tiger", "tight", "tilde", "timer", "timid", "tipsy", "titan", "tithe", "title", "toast", "today", "toddy", "token", "tonal", "tonga", "tonic", "tooth", "topaz", "topic", "torch", "torso", "torus", "total", "totem", "touch", "tough", "towel", "tower", "toxic", "toxin", "trace", "track", "tract", "trade", "trail", "train", "trait", "tramp", "trash", "trawl", "tread", "treat", "trend", "triad", "trial", "tribe", "trice", "trick", "tried", "tripe", "trite", "troll", "troop", "trope", "trout", "trove", "truce", "truck", "truer", "truly", "trump", "trunk", "truss", "trust", "truth", "tryst", "tubal", "tuber", "tubes", "tulip", "tulle", "tumor", "tunic", "turbo", "tutor", "twang", "tweak", "tweed", "tweet", "twice", "twine", "twirl", "twist", "twixt", "tying", "udder", "ulcer", "ultra", "umbra", "uncle", "uncut", "under", "undid", "undue", "unfed", "unfit", "unify", "union", "unite", "unity", "unlit", "unmet", "unset", "untie", "until", "unwed", "unzip", "upper", "upset", "urban", "urine", "usage", "usher", "using", "usual", "usurp", "utile", "utter", "vague", "valet", "valid", "valor", "value", "valve", "vapid", "vapor", "vault", "vaunt", "vegan", "venom", "venue", "verge", "verse", "verso", "verve", "vicar", "video", "vigil", "vigor", "villa", "vinyl", "viola", "viper", "viral", "virus", "visit", "visor", "vista", "vital", "vivid", "vixen", "vocal", "vodka", "vogue", "voice", "voila", "vomit", "voter", "vouch", "vowel", "vying", "wacky", "wafer", "wager", "wagon", "waist", "waive", "waltz", "warty", "waste", "watch", "water", "waver", "waxen", "weary", "weave", "wedge", "weedy", "weigh", "weird", "welch", "welsh", "wench", "whack", "whale", "wharf", "wheat", "wheel", "whelp", "where", "which", "whiff", "while", "whine", "whiny", "whirl", "whisk", "white", "whole", "whoop", "whose", "widen", "wider", "widow", "width", "wield", "wight", "willy", "wimpy", "wince", "winch", "windy", "wiser", "wispy", "witch", "witty", "woken", "woman", "women", "woody", "wooer", "wooly", "woozy", "wordy", "world", "worry", "worse", "worst", "worth", "would", "wound", "woven", "wrack", "wrath", "wreak", "wreck", "wrest", "wring", "wrist", "write", "wrong", "wrote", "wrung", "wryly", "yacht", "yearn", "yeast", "yield", "young", "youth", "zebra", "zesty", "zonal"};
    public static String[] triedWords = {"", "", "", "", "", "", ""};
    public static String chosenWord = wordList[(int)(Math.random() * wordList.length)].toUpperCase();

    /*█████╗ ██████╗ ██╗██████╗   ██╗   ██╗ █████╗ ██████╗ ██╗ █████╗ ██████╗ ██╗     ███████╗ ██████╗
    ██╔════╝ ██╔══██╗██║██╔══██╗  ██║   ██║██╔══██╗██╔══██╗██║██╔══██╗██╔══██╗██║     ██╔════╝██╔════╝
    ██║  ██╗ ██████╔╝██║██║  ██║  ╚██╗ ██╔╝███████║██████╔╝██║███████║██████╦╝██║     █████╗  ╚█████╗
    ██║  ╚██╗██╔══██╗██║██║  ██║   ╚████╔╝ ██╔══██║██╔══██╗██║██╔══██║██╔══██╗██║     ██╔══╝   ╚═══██╗
    ╚██████╔╝██║  ██║██║██████╔╝    ╚██╔╝  ██║  ██║██║  ██║██║██║  ██║██████╦╝███████╗███████╗██████╔╝
     ╚═════╝ ╚═╝  ╚═╝╚═╝╚═════╝      ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝╚═╝  ╚═╝╚═════╝ ╚══════╝╚══════╝╚════*/

    public static int current_row = 0, current_columns = 0;
    final public static int[][] grid_id = {
            {R.id.E11, R.id.E12, R.id.E13, R.id.E14, R.id.E15},
            {R.id.E21, R.id.E22, R.id.E23, R.id.E24, R.id.E25},
            {R.id.E31, R.id.E32, R.id.E33, R.id.E34, R.id.E35},
            {R.id.E41, R.id.E42, R.id.E43, R.id.E44, R.id.E45},
            {R.id.E51, R.id.E52, R.id.E53, R.id.E54, R.id.E55},
            {R.id.E61, R.id.E62, R.id.E63, R.id.E64, R.id.E65},
    };

    public void createGrid() {
        for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 5; j++) {
            TextView grid_tile = findViewById(grid_id[i][j]);
            grid_tile.setText("");
            grid_tile.setBackgroundResource(R.drawable.border);
        }}
    }
    
    /*╗  ██╗███████╗██╗   ██╗██████╗  █████╗  █████╗ ██████╗ ██████╗
    ██║ ██╔╝██╔════╝╚██╗ ██╔╝██╔══██╗██╔══██╗██╔══██╗██╔══██╗██╔══██╗
    █████═╝ █████╗   ╚████╔╝ ██████╦╝██║  ██║███████║██████╔╝██║  ██║
    ██╔═██╗ ██╔══╝    ╚██╔╝  ██╔══██╗██║  ██║██╔══██║██╔══██╗██║  ██║
    ██║ ╚██╗███████╗   ██║   ██████╦╝╚█████╔╝██║  ██║██║  ██║██████╔╝
    ╚═╝  ╚═╝╚══════╝   ╚═╝   ╚═════╝  ╚════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚════*/

    final public static int[][] keyboard_id = {
            {R.id.Q, R.id.W, R.id.E, R.id.R, R.id.T, R.id.Y, R.id.U},
            {R.id.I, R.id.O, R.id.P, R.id.A, R.id.S, R.id.D, R.id.F},
            {R.id.G, R.id.H, R.id.J, R.id.K, R.id.L, R.id.Z, R.id.X},
            {R.id.Enter, R.id.C, R.id.V, R.id.B, R.id.N, R.id.M, R.id.Delete},
    };

    final public static int[][] keyboard_color = new int[4][7];

    final public static String keyboard_position = "QWERTYUIOPASDFGHJKLZX1CVBNM2";

    public void createKeyboard() {
        for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 7; j++) {
            TextView key = findViewById(keyboard_id[i][j]);
            key.setBackgroundResource(R.drawable.not_selected);
            key.setOnClickListener(v -> {
                int key_id = v.getId();
                String key1 = (getResources().getResourceEntryName(key_id));
                switch (key1) {
                    case "Enter":
                        enterPressed();
                        break;
                    case "Delete":
                        deletePressed();
                        break;
                    default:
                        keyPressed(key1);
                }
            });
            // Change key-color
            keyboard_color[i][j] = 0; // 0 = Not Selected, 1 = Not there, 2 = Yellow Tile, 3 = Green Tile
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && !((i == 3 && j == 0) || (i == 3 && j == 6))) {
                key.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(174,174,174)));
            }
        }}
    }
    
    /*╗  ██╗███████╗██╗   ██╗     █████╗  █████╗ ███╗  ██╗████████╗██████╗  █████╗ ██╗      ██████╗
    ██║ ██╔╝██╔════╝╚██╗ ██╔╝    ██╔══██╗██╔══██╗████╗ ██║╚══██╔══╝██╔══██╗██╔══██╗██║     ██╔════╝
    █████═╝ █████╗   ╚████╔╝     ██║  ╚═╝██║  ██║██╔██╗██║   ██║   ██████╔╝██║  ██║██║     ╚█████╗
    ██╔═██╗ ██╔══╝    ╚██╔╝      ██║  ██╗██║  ██║██║╚████║   ██║   ██╔══██╗██║  ██║██║      ╚═══██╗
    ██║ ╚██╗███████╗   ██║       ╚█████╔╝╚█████╔╝██║ ╚███║   ██║   ██║  ██║╚█████╔╝███████╗██████╔╝
    ╚═╝  ╚═╝╚══════╝   ╚═╝        ╚════╝  ╚════╝ ╚═╝  ╚══╝   ╚═╝   ╚═╝  ╚═╝ ╚════╝ ╚══════╝╚════*/
    
    public void keyPressed(String key) {
        if (current_columns == 5) return;
        TextView tile = findViewById(grid_id[current_row][current_columns]);
        tile.setText(key);
        current_columns++;
    }

    public static boolean gameOver = false;

    public void enterPressed() {
        // Don't run if game is over
        if (gameOver) {newGame(); return;}

        // Check if there are enough letters
        if (current_columns < 5) {
            showDialog("There are not enough letters. Please enter a 5 letter word.");
            return;
        }

        String input_word = constructWord().toUpperCase();

        // Check if current word is valid
        if (!listContainsWord(input_word.toLowerCase())) {
            showDialog("The dictionary does not contain this word. Please try again.");
            return;
        }
        if (wordHasBeenTried(input_word)) {
            showDialog("The word has already been tried above ! Try something else...");
            return;
        }

        Log.d("CHEATER", "TRY : " + input_word);

        // Check Green Tiles
        String letters_remaining = checkGreenTiles(input_word);

        // Check Yellow Tiles
        checkYellowTiles(letters_remaining, input_word);

        // No more tries left for player
        if (current_row == 5 && !gameOver) {
            // Execute Ending Code
            gameOver = true;
            showDialog("GAME OVER, THE WORD WAS " + chosenWord);
            statistic.put("loses", statistic.get("loses") + 1);
        }
        // Proceed to next row
        else {
            triedWords[current_row] = input_word;
            current_row++;
            current_columns = 0;
        }
    }

    public void deletePressed() {
        current_columns = Math.max(0, current_columns - 1);
        TextView tile = findViewById(grid_id[current_row][current_columns]);
        tile.setText("");
    }
    
    /*╗███╗  ██╗██╗   ██╗ █████╗ ██╗     ██╗██████╗     ██╗   ██╗ █████╗ ██╗     ██╗   ██╗███████╗ ██████╗
    ██║████╗ ██║██║   ██║██╔══██╗██║     ██║██╔══██╗    ██║   ██║██╔══██╗██║     ██║   ██║██╔════╝██╔════╝
    ██║██╔██╗██║╚██╗ ██╔╝███████║██║     ██║██║  ██║    ╚██╗ ██╔╝███████║██║     ██║   ██║█████╗  ╚█████╗
    ██║██║╚████║ ╚████╔╝ ██╔══██║██║     ██║██║  ██║     ╚████╔╝ ██╔══██║██║     ██║   ██║██╔══╝   ╚═══██╗
    ██║██║ ╚███║  ╚██╔╝  ██║  ██║███████╗██║██████╔╝      ╚██╔╝  ██║  ██║███████╗╚██████╔╝███████╗██████╔╝
    ╚═╝╚═╝  ╚══╝   ╚═╝   ╚═╝  ╚═╝╚══════╝╚═╝╚═════╝        ╚═╝   ╚═╝  ╚═╝╚══════╝ ╚═════╝ ╚══════╝╚════*/

    private static HashMap<String, Integer> statistic = new HashMap<String, Integer>(){{
       put("wins", 0); put("loses", 0);
    }};

    public void showDialog(String error) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.not_enough_letters);

        TextView message = (dialog.findViewById(R.id.alert));
        message.setText(error);

        TextView score = (dialog.findViewById(R.id.scoreCounter));
        String note = "Wins : " + statistic.get("wins") + " | Loses : " + statistic.get("loses");
        score.setText(note);

        Button newGameButton = dialog.findViewById(R.id.newGame);
        if (gameOver) {
            newGameButton.setVisibility(View.VISIBLE);
            newGameButton.setOnClickListener(v -> newGame());
            score.setVisibility(View.VISIBLE);
        }
        else {
            newGameButton.setVisibility(View.GONE);
            score.setVisibility(View.GONE);
        }

        dialog.show();
    }

    /*████╗  █████╗  ██╗       ██╗   █████╗ ██╗  ██╗███████╗ █████╗ ██╗  ██╗
    ██╔══██╗██╔══██╗ ██║  ██╗  ██║  ██╔══██╗██║  ██║██╔════╝██╔══██╗██║ ██╔╝
    ██████╔╝██║  ██║ ╚██╗████╗██╔╝  ██║  ╚═╝███████║█████╗  ██║  ╚═╝█████═╝ 
    ██╔══██╗██║  ██║  ████╔═████║   ██║  ██╗██╔══██║██╔══╝  ██║  ██╗██╔═██╗ 
    ██║  ██║╚█████╔╝  ╚██╔╝ ╚██╔╝   ╚█████╔╝██║  ██║███████╗╚█████╔╝██║ ╚██╗
    ╚═╝  ╚═╝ ╚════╝    ╚═╝   ╚═╝     ╚════╝ ╚═╝  ╚═╝╚══════╝ ╚════╝ ╚═╝  ╚*/

    public String constructWord() {
        StringBuilder input_word_finder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            TextView tile = findViewById(grid_id[current_row][i]);
            char letter = tile.getText().charAt(0);
            input_word_finder.append(letter);
        }
        return input_word_finder.toString().toLowerCase();
    }

    public boolean listContainsWord(String word) {
        int firstLetter = word.charAt(0);
        for (String s : wordList) {
            if (s.equals(word)) return true;
            if (firstLetter < (int) (s.charAt(0))) return false;
        }
        return false;
    }

    public boolean wordHasBeenTried(String word) {
        for (String s : triedWords) {
            if (s.equals(word)) return true;
        }
        return false;
    }

    public String checkGreenTiles(String input) {
        StringBuilder remaining_letters = new StringBuilder();
        int correctCounter = 0;
        for (int i = 0; i < input.length(); i++) {
            // Search for correct letters at correct position
            if (input.charAt(i) == chosenWord.charAt(i)) {
                // Change tile into green tile
                TextView tile = findViewById(grid_id[current_row][i]);
                tile.setBackgroundResource(R.drawable.green_tile);
                tile.setTextColor(Color.WHITE);
                // Add placeholder in char array
                remaining_letters.append("*");
                // Add 1 to correctCounter
                correctCounter++;
                // Change matching key to green color
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    int keyPosition = keyboard_position.indexOf(input.charAt(i));
                    findViewById(keyboard_id[keyPosition / 7][keyPosition % 7]).setBackgroundTintList(ColorStateList.valueOf(Color.rgb(76, 175, 80)));
                    keyboard_color[keyPosition / 7][keyPosition % 7] = 3;
                }
            }
            // Add remaining letters to check for yellow/gray tiles
            else remaining_letters.append(chosenWord.charAt(i));
        }
        if (correctCounter == chosenWord.length()) {
            showDialog("\uD83C\uDF89 Congratulation \uD83C\uDF89\n You found the word");
            gameOver = true;
            statistic.put("wins", statistic.get("wins") + 1);
        }
        return remaining_letters.toString();
    }

    public void checkYellowTiles(String lettersToCheck, String input) {
        String remainder = lettersToCheck;
        for (int i = 0; i < remainder.length(); i++) {
            // Find the current tile to change color
            TextView tile = findViewById(grid_id[current_row][i]);

            if (remainder.charAt(i) == '*') continue;

            // Detects a correct letter at the wrong spot
            if (remainder.contains(String.valueOf(input.charAt(i)))) {
                // Change tile to yellow tile
                tile.setBackgroundResource(R.drawable.yellow_tile);

                StringBuilder newString = new StringBuilder();
                // String.replaceFirst() is weird in Android Studio
                for (int j = 0; j < remainder.length(); j++) {
                    if (remainder.charAt(j) == input.charAt(i)) {
                        newString.append("-"); continue;
                    }
                    newString.append(remainder.charAt(j));
                }
                remainder = newString.toString();

                // Change corresponding key with yellow tint
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    int keyPosition = keyboard_position.indexOf(input.charAt(i));
                    if (keyboard_color[keyPosition / 7][keyPosition % 7] != 3) {
                        findViewById(keyboard_id[keyPosition / 7][keyPosition % 7]).setBackgroundTintList(ColorStateList.valueOf(Color.rgb(255, 193, 7)));
                        keyboard_color[keyPosition / 7][keyPosition % 7] = 2;
                    }
                }
            }
            // Detects a letter that is not present in the word
            else {
                // Change tile to gray tile
                tile.setBackgroundResource(R.drawable.grey_tile);

                // Change corresponding key with gray tint
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    int keyPosition = keyboard_position.indexOf(input.charAt(i));
                    if (keyboard_color[keyPosition / 7][keyPosition % 7] <= 1) {
                        findViewById(keyboard_id[keyPosition / 7][keyPosition % 7]).setBackgroundTintList(ColorStateList.valueOf(Color.rgb(43, 40, 40)));
                        keyboard_color[keyPosition / 7][keyPosition % 7] = 2;
                    }
                }
            }
            tile.setTextColor(Color.WHITE);
        }
    }

    /*████╗ ██████╗ ██╗██╗   ██╗███████╗██████╗    █████╗  █████╗ ██████╗ ███████╗
    ██╔══██╗██╔══██╗██║██║   ██║██╔════╝██╔══██╗  ██╔══██╗██╔══██╗██╔══██╗██╔════╝
    ██║  ██║██████╔╝██║╚██╗ ██╔╝█████╗  ██████╔╝  ██║  ╚═╝██║  ██║██║  ██║█████╗
    ██║  ██║██╔══██╗██║ ╚████╔╝ ██╔══╝  ██╔══██╗  ██║  ██╗██║  ██║██║  ██║██╔══╝
    ██████╔╝██║  ██║██║  ╚██╔╝  ███████╗██║  ██║  ╚█████╔╝╚█████╔╝██████╔╝███████╗
    ╚═════╝ ╚═╝  ╚═╝╚═╝   ╚═╝   ╚══════╝╚═╝  ╚═╝   ╚════╝  ╚════╝ ╚═════╝ ╚═════*/

    public void newGame() {
        // Create keyboard again
        createKeyboard();

        // Create grid again
        current_columns = 0; current_row = 0;
        createGrid();

        // Chose new word
        chosenWord = wordList[(int)(Math.random() * wordList.length)].toUpperCase();

        // Resets gameOver boolean
        gameOver = false;

        // Resets tried words
        for (String word : triedWords) word = "";

        // Log new word for debugging ;)
        Log.d("CHEATER", chosenWord);
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, English.class);
    }

    private void setupEndActivityButton() {
        Button btn = findViewById(R.id.english_back_button);
        btn.setOnClickListener(v -> {
            newGame(); finish();
        });
    }

    // When page is initially created

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);

        // Create option to go back to menu
        setupEndActivityButton();

        // Create new game
        newGame();
    }
}