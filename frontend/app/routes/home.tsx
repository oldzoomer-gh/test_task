import { init, retrieveRawInitData } from '@telegram-apps/sdk';

export default function Home() {
  init();
  
  if (document.cookie.length === 0) {
    auth();
  }

  const userInfoData = userInfo();

  return (
    <main className="flex min-h-screen flex-col justify-center items-center p-10">
      <div className="flex flex-col max-w-5xl w-full justify-center items-center text-sm">
        <h1>Hello, {userInfoData.username}</h1>
        <h1>Your real name is {userInfoData.first_name} {userInfoData.last_name}</h1>
        <h1>Your id is {userInfoData.id}</h1>
        <h1>Your language code is {userInfoData.language_code}</h1>
        <h1>Premium is {userInfoData.is_premium}</h1>
      </div>
    </main>
  );
}

async function auth() {
  fetch(import.meta.env.VITE_API_URL + '/auth' as string, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json;charset=utf-8'
    },
    body: JSON.stringify(retrieveRawInitData()),
    credentials: 'include'
  });
}

async function userInfo() {
  return await fetch(import.meta.env.VITE_API_URL + '/userInfo' as string, {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json;charset=utf-8'
    },
    credentials: 'include'
  }).then(res => res.json());
}