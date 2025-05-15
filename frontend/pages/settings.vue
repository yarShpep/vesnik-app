<template>
  <v-container class="pa-6">
    <h1 class="text-h5 mb-4">⚙️ Настройки</h1>
    <v-card>
      <v-card-text>
        <v-switch
          v-model="isDark"
          label="Темная тема"
          inset
        />
      </v-card-text>
    </v-card>
  </v-container>
</template>

<script setup>
import { computed, onMounted } from 'vue'
import { useTheme } from 'vuetify'

const theme = useTheme()

const isDark = computed({
  get: () => theme.global.name.value === 'dark',
  set: (val) => {
    const mode = val ? 'dark' : 'light'
    theme.global.name.value = mode
    localStorage.setItem('theme', mode)
  }
})

onMounted(() => {
  const savedTheme = localStorage.getItem('theme')
  if (savedTheme === 'dark' || savedTheme === 'light') {
    theme.global.name.value = savedTheme
  }
})
</script>