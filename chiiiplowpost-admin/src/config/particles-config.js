import { loadFull } from "tsparticles";
export const particlesOptions = {
    background: { color: { value: "#FFF" } },
    fpsLimit: 120,
    interactivity: {
        events: {
            onClick: { enable: true, mode: "push" },
            onHover: { enable: true, mode: "repulse" },
            resize: true,
        },
        modes: {
            bubble: { distance: 300, duration: 3, opacity: 1, size: 30 },
            push: { quantity: 4 },
            repulse: { distance: 200, duration: 0.4 },
        },
    },
    particles: {
        color: { value: "#0B243B" },
        links: {
            color: "#0B243B",
            distance: 50,
            enable: true,
            opacity: 0.5,
            width: 1,
        },
        collisions: { enable: true },
        move: {
            direction: "none",
            enable: true,
            outModes: { default: "bounce" },
            random: false,
            speed: 3,
            straight: false,
        },
        number: { density: { enable: true, area: 1000 }, value: 120 },
        opacity: { value: 0.5 },
        shape: { type: "circle" },
        size: { value: { min: 1, max: 5 } },
    },
    detectRetina: true,
}

export const particlesLoaded = async (container) => {
    console.log("Particles container loaded", container);
};

export const particlesInit = async (engine) => {
    await loadFull(engine);
};