import type { Telegram } from "@twa-dev/types";

declare global {
  interface Window {
    Telegram: Telegram;
  }
}

export default function Home() {
//  return ();
}

async function auth() {
  const initData = window.Telegram.WebApp.initData;

  await fetch(process.env.API_URL + '/auth', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json;charset=utf-8'
    },
    body: JSON.stringify(initData),
    credentials: 'include'
  }).then(res => res.json());
}

async function userInfo() {
  return await fetch(process.env.API_URL + '/userInfo', {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json;charset=utf-8'
    },
    credentials: 'include'
  }).then(res => res.json());
}