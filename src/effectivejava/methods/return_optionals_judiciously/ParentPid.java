package effectivejava.methods.return_optionals_judiciously;

import java.util.Optional;

// Avoiding unnecessary use of Optional's isPresent method
public class ParentPid {
    public static void main(String[] args) {
        ProcessHandle ph = ProcessHandle.current();

        // Inappropriate use of isPresent
        Optional<ProcessHandle> parentProcess = ph.parent();
        System.out.println("Parent PID: " + (parentProcess.isPresent() ?
                String.valueOf(parentProcess.get().pid()) : "N/A"));

        // Equivalent (and superior) code using orElse
        System.out.println("Parent PID: " +
            ph.parent().map(h -> String.valueOf(h.pid())).orElse("N/A"));
    }
}
