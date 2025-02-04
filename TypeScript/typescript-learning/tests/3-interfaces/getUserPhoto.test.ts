import { describe, it, expect } from 'vitest'
import { getUserPhoto } from '../../functions/3-interfaces'

describe('getUserPhoto', () => {
  it('retourne l\'url de la photo utilisateur', () => {
    const user = {
      name: 'Amy',
      verified: false,
      picture: 'https://example.com/amy.jpg',
    }
    expect(typeof getUserPhoto(user)).toBe('string')
    expect(getUserPhoto(user)).toBe('https://example.com/amy.jpg')
  })

  it('retourne l\'url d\'une photo de chien', () => {
    const user = {
      name: 'Amy',
      verified: false,
    }
    expect(typeof getUserPhoto(user)).toBe('string')
    expect(getUserPhoto(user)).toBe('https://place.dog/300/200')
  })
})
