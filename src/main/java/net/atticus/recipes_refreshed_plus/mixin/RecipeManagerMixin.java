package net.atticus.recipes_refreshed_plus.mixin;

import java.util.Map;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.google.gson.JsonElement;

import net.atticus.recipes_refreshed_plus.recipe.ModRecipeManager;
import net.atticus.recipes_refreshed_plus.recipe.RecipeJson;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;

@Mixin(RecipeManager.class)
public class RecipeManagerMixin {

    @Inject(method = "apply", at = @At("HEAD"))
    public void interceptApply(Map<Identifier, JsonElement> map, ResourceManager resourceManager, Profiler profiler,
            CallbackInfo info) {
        for (RecipeJson recipe : ModRecipeManager.recipes) {
            map.put(recipe.getIdentifier(), recipe.getRecipe());
        }
    }
}
