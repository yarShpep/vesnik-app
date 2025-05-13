<template>
  <v-app>
    <v-app-bar color="primary" class="flex-grow-0" app dark>
      <v-btn icon @click.stop="drawer = !drawer">
        <v-icon>mdi-menu</v-icon>
      </v-btn>
      <NuxtLink to="/" style="text-decoration: none; color: inherit;">
        <v-app-bar-title>Вестник</v-app-bar-title>
      </NuxtLink>
    </v-app-bar>

    <v-navigation-drawer app v-model="drawer" bottom>
      <v-list-item>
        <v-list-item-content>
          <v-list-item-title class="text-h6">Меню</v-list-item-title>
          <v-list-item-subtitle>Навигация</v-list-item-subtitle>
        </v-list-item-content>
      </v-list-item>

      <v-divider></v-divider>

      <v-list dense nav>
        <v-list-item
          v-for="item in items"
          :key="item.title"
          :to="item.route"
          link
          @click="drawer = false"
        >
          <v-list-item-icon>
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-item-icon>
          <v-list-item-content>
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
</v-navigation-drawer>

    <v-main>
      <NuxtPage />
    </v-main>
  </v-app>
</template>

<script setup>
import { ref } from 'vue'

const drawer = ref(false)
const items = [
  { title: 'Инциденты', icon: 'mdi-view-list', route: '/incidents' },
  { title: 'Сообщить', icon: 'mdi-plus-box', route: '/report' },
  { title: 'Карта', icon: 'mdi-map', route: '/map' },
  { title: 'Настройки', icon: 'mdi-cog', route: '/settings' }
]
</script>