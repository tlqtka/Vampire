package tlqtka.plugin.vampire;

import io.papermc.paper.world.MoonPhase;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class Main extends JavaPlugin implements Listener {

    boolean weatherRain = false;
    boolean aboveBlock = true;
    private boolean weatherRaining;

    @Override
    public void onEnable() {
        getLogger().info("Vampire Plugin is Enabled!");
        Bukkit.getPluginManager().registerEvents(this,this);
        if (weatherRaining) {
            Objects.requireNonNull(Bukkit.getWorld("world")).setWeatherDuration(1);
            weatherRaining = false;
        }
        Bukkit.getScheduler().runTaskTimer(this, new Runnable() {
            @Override
            public void run() {
                checkPlayerLocation();
            }
        }, 0, 20);
    }

    private void checkPlayerLocation() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            Location loc = p.getLocation();

            double checkBlock = 1.0;
            double maxCheckBlock = 384.0;

            long time = p.getWorld().getTime();
            World.Environment worldChecking = p.getWorld().getEnvironment();
            boolean inNether = false;
            boolean inEnd = false;

            aboveBlock = false;

            while (checkBlock <= maxCheckBlock) {
                Location blockAboveLoc = loc.clone().add(0, checkBlock, 0);

                if (blockAboveLoc.clone().getBlock().getType().isSolid() || blockAboveLoc.clone().getBlock().isLiquid()) {
                    aboveBlock = true;
                    break;
                }
                checkBlock++;
            }
            if (worldChecking == World.Environment.NETHER) {
                inNether = true;
            }
            if (worldChecking == World.Environment.THE_END) {
                inEnd = true;
            }
            if (loc.getBlockY() >= 319.0) {
                aboveBlock = false;
            }
            if (inNether) {
                boolean helmet = p.getInventory().getHelmet() != null;
                if (helmet) {
                    ItemStack pHelmet = p.getInventory().getHelmet();
                    if (pHelmet.getType() == Material.LEATHER_HELMET) {
                        if (Math.random() < 0.5) {
                            pHelmet.damage(1, p);
                        } else {
                            double additionalDamage = 1.0;
                            p.damage(additionalDamage);
                            p.spawnParticle(Particle.REDSTONE, loc.getX(), loc.getY() + 1.0, loc.getZ(), 5, 0.5, 0.5, 0.5, 1.0,
                                    new Particle.DustOptions(Color.fromRGB(255, 0, 0), 1));
                        }
                    } else if (pHelmet.getType() == Material.CHAINMAIL_HELMET) {
                        if (Math.random() < 0.01) {
                            pHelmet.damage(1, p);
                            p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20*60, 1, false, false));
                        } else {
                            double additionalDamage = 1.0;
                            p.damage(additionalDamage);
                            p.spawnParticle(Particle.REDSTONE, loc.getX(), loc.getY() + 1.0, loc.getZ(), 5, 0.5, 0.5, 0.5, 1.0,
                                    new Particle.DustOptions(Color.fromRGB(255, 0, 0), 1));
                        }
                    } else if (pHelmet.getType() == Material.GOLDEN_HELMET) {
                        if (Math.random() < 0.95) {
                            pHelmet.damage(1, p);
                        } else {
                            double additionalDamage = 1.0;
                            p.damage(additionalDamage);
                            p.spawnParticle(Particle.REDSTONE, loc.getX(), loc.getY() + 1.0, loc.getZ(), 5, 0.5, 0.5, 0.5, 1.0,
                                    new Particle.DustOptions(Color.fromRGB(255, 0, 0), 1));
                        }
                    } else if (pHelmet.getType() == Material.IRON_HELMET) {
                        if (Math.random() < 0.8) {
                            pHelmet.damage(1, p);
                        } else {
                            double additionalDamage = 1.0;
                            p.damage(additionalDamage);
                            p.spawnParticle(Particle.REDSTONE, loc.getX(), loc.getY() + 1.0, loc.getZ(), 5, 0.5, 0.5, 0.5, 1.0,
                                    new Particle.DustOptions(Color.fromRGB(255, 0, 0), 1));
                        }
                    } else if (pHelmet.getType() == Material.DIAMOND_HELMET) {
                        if (Math.random() < 0.90) {
                            pHelmet.damage(1, p);
                        } else {
                            double additionalDamage = 1.0;
                            p.damage(additionalDamage);
                            p.spawnParticle(Particle.REDSTONE, loc.getX(), loc.getY() + 1.0, loc.getZ(), 5, 0.5, 0.5, 0.5, 1.0,
                                    new Particle.DustOptions(Color.fromRGB(255, 0, 0), 1));
                        }
                    } else if (pHelmet.getType() == Material.NETHERITE_HELMET) {
                        if (Math.random() < 0.99) {
                            pHelmet.damage(1, p);
                        } else {
                            double additionalDamage = 1.0;
                            p.damage(additionalDamage);
                            p.spawnParticle(Particle.REDSTONE, loc.getX(), loc.getY() + 1.0, loc.getZ(), 5, 0.5, 0.5, 0.5, 1.0,
                                    new Particle.DustOptions(Color.fromRGB(255, 0, 0), 1));
                        }
                    } else if (pHelmet.getType() == Material.CREEPER_HEAD ||
                               pHelmet.getType() == Material.PLAYER_HEAD ||
                               pHelmet.getType() == Material.SKELETON_SKULL ||
                               pHelmet.getType() == Material.ZOMBIE_HEAD ||
                               pHelmet.getType() == Material.PIGLIN_HEAD ||
                               pHelmet.getType() == Material.DRAGON_HEAD ||
                               pHelmet.getType() == Material.WITHER_SKELETON_SKULL) {
                        if (Math.random() < 0.0001) {
                            pHelmet.setAmount(0);
                        } else {
                            double additionalDamage = 1.0;
                            p.damage(additionalDamage);
                            p.spawnParticle(Particle.REDSTONE, loc.getX(), loc.getY() + 1.0, loc.getZ(), 5, 0.5, 0.5, 0.5, 1.0,
                                    new Particle.DustOptions(Color.fromRGB(255, 0, 0), 1));
                        }
                    }
                } else {
                    double additionalDamage = 1.0;
                    p.damage(additionalDamage);
                    p.spawnParticle(Particle.REDSTONE, loc.getX(), loc.getY() + 1.0, loc.getZ(), 5, 0.5, 0.5, 0.5, 1.0,
                            new Particle.DustOptions(Color.fromRGB(255, 0, 0), 1));
                }
            }
            if (!aboveBlock) {
                if (time >= 0 && time < 13000) {
                    if (!inEnd) {
                        if (!weatherRain) {
                            boolean helmet = p.getInventory().getHelmet() != null;
                            if (helmet) {
                                ItemStack pHelmet = p.getInventory().getHelmet();
                                if (pHelmet.getType() == Material.LEATHER_HELMET) {
                                    if (Math.random() < 0.5) {
                                        pHelmet.damage(1, p);
                                    } else {
                                        double additionalDamage = 1.0;
                                        p.damage(additionalDamage);
                                        p.spawnParticle(Particle.REDSTONE, loc.getX(), loc.getY() + 1.0, loc.getZ(), 5, 0.5, 0.5, 0.5, 1.0,
                                                new Particle.DustOptions(Color.fromRGB(255, 0, 0), 1));
                                    }
                                } else if (pHelmet.getType() == Material.CHAINMAIL_HELMET) {
                                    if (Math.random() < 0.001) {
                                        p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20 * 180, 1, false, false));
                                    } else {
                                        double additionalDamage = 1.0;
                                        p.damage(additionalDamage);
                                        p.spawnParticle(Particle.REDSTONE, loc.getX(), loc.getY() + 1.0, loc.getZ(), 5, 0.5, 0.5, 0.5, 1.0,
                                                new Particle.DustOptions(Color.fromRGB(255, 0, 0), 1));
                                    }
                                } else if (pHelmet.getType() == Material.GOLDEN_HELMET) {
                                    if (Math.random() < 0.85) {
                                        pHelmet.damage(1, p);
                                    } else {
                                        double additionalDamage = 1.0;
                                        p.damage(additionalDamage);
                                        p.spawnParticle(Particle.REDSTONE, loc.getX(), loc.getY() + 1.0, loc.getZ(), 5, 0.5, 0.5, 0.5, 1.0,
                                                new Particle.DustOptions(Color.fromRGB(255, 0, 0), 1));
                                    }
                                } else if (pHelmet.getType() == Material.IRON_HELMET) {
                                    if (Math.random() < 0.7) {
                                        pHelmet.damage(1, p);
                                    } else {
                                        double additionalDamage = 1.0;
                                        p.damage(additionalDamage);
                                        p.spawnParticle(Particle.REDSTONE, loc.getX(), loc.getY() + 1.0, loc.getZ(), 5, 0.5, 0.5, 0.5, 1.0,
                                                new Particle.DustOptions(Color.fromRGB(255, 0, 0), 1));
                                    }
                                } else if (pHelmet.getType() == Material.DIAMOND_HELMET) {
                                    if (Math.random() < 0.90) {
                                        pHelmet.damage(1, p);
                                    } else {
                                        double additionalDamage = 1.0;
                                        p.damage(additionalDamage);
                                        p.spawnParticle(Particle.REDSTONE, loc.getX(), loc.getY() + 1.0, loc.getZ(), 5, 0.5, 0.5, 0.5, 1.0,
                                                new Particle.DustOptions(Color.fromRGB(255, 0, 0), 1));
                                    }
                                } else if (pHelmet.getType() == Material.NETHERITE_HELMET) {
                                    if (Math.random() < 0.999) {
                                        pHelmet.damage(1, p);
                                    } else {
                                        double additionalDamage = 1.0;
                                        p.damage(additionalDamage);
                                        p.spawnParticle(Particle.REDSTONE, loc.getX(), loc.getY() + 1.0, loc.getZ(), 5, 0.5, 0.5, 0.5, 1.0,
                                                new Particle.DustOptions(Color.fromRGB(255, 0, 0), 1));
                                    }
                                } else if (pHelmet.getType() == Material.CREEPER_HEAD ||
                                        pHelmet.getType() == Material.PLAYER_HEAD ||
                                        pHelmet.getType() == Material.SKELETON_SKULL ||
                                        pHelmet.getType() == Material.ZOMBIE_HEAD ||
                                        pHelmet.getType() == Material.PIGLIN_HEAD ||
                                        pHelmet.getType() == Material.DRAGON_HEAD ||
                                        pHelmet.getType() == Material.WITHER_SKELETON_SKULL) {
                                    if (Math.random() < 0.0001) {
                                        double additionalDamage = 1.0;
                                        p.damage(additionalDamage);
                                        p.spawnParticle(Particle.REDSTONE, loc.getX(), loc.getY() + 1.0, loc.getZ(), 5, 0.5, 0.5, 0.5, 1.0,
                                                new Particle.DustOptions(Color.fromRGB(255, 0, 0), 1));
                                        pHelmet.setAmount(0);
                                    }
                                }
                            } else {
                                double additionalDamage = 1.0;
                                p.damage(additionalDamage);
                                p.spawnParticle(Particle.REDSTONE, loc.getX(), loc.getY() + 1.0, loc.getZ(), 5, 0.5, 0.5, 0.5, 1.0,
                                        new Particle.DustOptions(Color.fromRGB(255, 0, 0), 1));
                            }
                        }
                    }
                }
            }
            if (time >= 13000) {
                @NotNull MoonPhase moon = p.getWorld().getMoonPhase();
                if (moon == MoonPhase.FULL_MOON) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 20*20, 0, false, false));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20*3, 1, false, false));
                } else if (moon == MoonPhase.NEW_MOON) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 20*3, 0, false, false));
                } else {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 20*20, 0, false, false));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20*3, 0, false, false));
                }
            }
        }
    }


    @EventHandler
    public void onPlayerKillEntity(EntityDeathEvent e) {
        if (e.getEntity().getKiller() != null) {
            Player p = e.getEntity().getKiller();
            Location loc = p.getLocation();
            p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 20*60, 0, false, false));
            if ((Objects.requireNonNull(e.getEntityType().getDefaultAttributes().getAttribute(Attribute.GENERIC_MAX_HEALTH))).getDefaultValue() / 10 + p.getHealth() <= 20) {
                p.setHealth(Objects.requireNonNull(e.getEntityType().getDefaultAttributes().getAttribute(Attribute.GENERIC_MAX_HEALTH)).getDefaultValue() / 10 + p.getHealth());
            } else {
                p.setHealth(20);
            }
            p.spawnParticle(Particle.REDSTONE, loc.x(), loc.y() + 1.0, loc.z(), 5, 0.5, 0.5, 0.5, 1.0,
                    new Particle.DustOptions(Color.fromRGB(255, 0, 0), 1));
        }
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent e) {
        weatherRain = e.toWeatherState();
    }

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent e) {
        if (e.getEntity() instanceof EnderDragon) {
            EnderDragon dragon = (EnderDragon) e.getEntity();
            Objects.requireNonNull(dragon.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(4096);
            dragon.setHealth(4096);
        }
    }

    @Override
    public void onDisable() {
        getLogger().warning("Vampire Plugin is Disabled!");
        if (weatherRain) {
            weatherRaining = true;
            Objects.requireNonNull(Bukkit.getWorld("world")).setWeatherDuration(0);
        }
    }
}