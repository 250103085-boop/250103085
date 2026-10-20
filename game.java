class ModernConsole {
    public void playDigital() {
        System.out.println("Modern console is loading a digital game...");
        System.out.println("Now playing digital game!");
    }
}

class RetroCartridge {
    private final String gameName;

    public RetroCartridge(String gameName) {
        this.gameName = gameName;
    }

    public void insertCartridge() {
        System.out.println("Inserting retro cartridge: " + gameName);
        System.out.println("Retro game '" + gameName + "' is running!");
    }

    public String getGameName() {
        return gameName;
    }
}
class CartridgeAdapter extends ModernConsole {
    private final RetroCartridge cartridge;

    public CartridgeAdapter(RetroCartridge cartridge) {
        this.cartridge = cartridge;
    }

    @Override
    public void playDigital() {
        cartridge.insertCartridge();
    }
}


public class game{
    public static void main(String[] args) {
        System.out.println("1. Modern console");
        ModernConsole modern = new ModernConsole();
        modern.playDigital();
        System.out.println();
        System.out.println("2. Retro cartridge alone");
        RetroCartridge retro = new RetroCartridge("Super Mario 1990");
        retro.insertCartridge();
        System.out.println();
        System.out.println("3. Modern console + Adapter runs the retro game");
        ModernConsole adapted = new CartridgeAdapter(new RetroCartridge("Super Mario 1990"));
        adapted.playDigital();

        System.out.println();
        System.out.println(" 4. Works anywhere ModernConsole is expected");
        ModernConsole[] consoles = {new ModernConsole(), new CartridgeAdapter(new RetroCartridge("Contra")), new CartridgeAdapter(new RetroCartridge("Battle City"))
        };
        for (ModernConsole c:consoles) {
            c.playDigital();
            System.out.println("---");
        }
    }
}